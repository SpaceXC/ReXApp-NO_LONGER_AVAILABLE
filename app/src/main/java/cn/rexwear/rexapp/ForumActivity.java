package cn.rexwear.rexapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.rexwear.rexapp.javabeans.ForumBean;
import cn.rexwear.rexapp.javabeans.NodeBean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

public class ForumActivity extends AppCompatActivity {
    final static String TAG = "TAG";
    private ForumViewModel ViewModel;
    RecyclerView forumRecyclerView;
    ForumActivityAdapter forumAdapter;
    String forumID;
    final ExecutorService mThreadPool = Executors.newCachedThreadPool();
    SwipeRefreshLayout swipeRefreshLayout;
    NetworkUtils network;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        forumID = getIntent().getStringExtra("forumID");
        TextView title = findViewById(R.id.forumTitleText);
        title.setText(getIntent().getStringExtra("forumName"));
        network = NetworkUtils.getInstance(ForumActivity.this);
        Log.d(TAG, "onActivityCreated: " + network.client);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        forumRecyclerView = findViewById(R.id.forumRecyclerView);

        forumAdapter = new ForumActivityAdapter();
        forumRecyclerView.setLayoutManager(new LinearLayoutManager(ForumActivity.this));
        forumRecyclerView.setAdapter(forumAdapter);

        swipeRefreshLayout.setColorSchemeColors(Color.parseColor("#1E96F2"), Color.parseColor("#BBE2F3"), Color.parseColor("#42BAE4"));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                GetData(forumID);
            }
        });

        Log.d(TAG, "onActivityCreated: 当前RecyclerView下的item数量：" + forumAdapter.getItemCount());
        if(forumAdapter.getItemCount() == 0){
            swipeRefreshLayout.setRefreshing(true);
            GetData(forumID);
        }
    }

    void GetData(String forumID){
        Log.d(TAG, "GetData: 开始请求论坛数据......");

        Request request = new Request.Builder()
                .url("https://rexwear.cn/index.php?api/forums/" + forumID + "/&with_threads=true")
                .method("GET", null)
                .addHeader("User-Agent", "ReXAppAndroid/JavaOkHttpRequested")
                .addHeader("XF-API-Key", "x3KEr7kI-ZOrNOjN46HAkB0oGgqHkXLt")
                //.addHeader("XF-Api-User", "37")
                .build();
        network.client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                if(e instanceof SocketTimeoutException){//判断超时异常
                    Log.d(TAG, "onFailure: ");
                    Looper.prepare();
                    Toast.makeText(ForumActivity.this, "网络连接超时！", Toast.LENGTH_LONG).show();
                    swipeRefreshLayout.setRefreshing(false);
                    Looper.loop();
                }
                if(e instanceof ConnectException){//判断连接异常，我这里是报Failed to connect to 10.7.5.144
                    Log.d(TAG, "onFailure: ");
                    Looper.prepare();
                    Toast.makeText(ForumActivity.this, "网络链接错误，请检查您的网络！", Toast.LENGTH_LONG).show();
                    swipeRefreshLayout.setRefreshing(false);
                    Looper.loop();
                }


            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String resultJson = response.body().string();
                Log.d(TAG, "onResponse: " + resultJson);

                ForumBean responseResult = ForumBean.objectFromData(resultJson);
                List<ForumBean.ThreadsDTO> resultList = responseResult.threads;


                /*forumAdapter.setNodesList(resultList);
                forumAdapter.notifyDataSetChanged();*/

                UpdateRecyclerView(resultList);

                /*//Log.d(TAG, "onResponse: "+responseResult.nodes);
                Log.d(TAG, "onResponse: ------------------RESULTS------------------");
                for (int i = 0; i < resultList.size(); i++) {
                    Log.d(TAG, "onResponse: node no." + i + ":" + resultList.get(i).title + "description: " + resultList.get(i).description);
                }
                Log.d(TAG, "onResponse: ------------------RESULTS------------------");*/
                Log.d(TAG, "onResponse: 完成请求论坛数据！");
                Looper.prepare();
                swipeRefreshLayout.setRefreshing(false);
                Looper.loop();

            }
        });
    }

    void UpdateRecyclerView(List<ForumBean.ThreadsDTO> resultList){
        mThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                ForumActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        forumAdapter.setThreadsList(resultList);
                        forumAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }
}