package cn.rexwear.rexapp;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.rexwear.rexapp.javabeans.NodeBean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

public class ForumFragment extends Fragment {
    final static String TAG = "TAG";
    private ForumViewModel ViewModel;
    RecyclerView forumRecyclerView;
    ForumAdapter forumAdapter;
    final ExecutorService mThreadPool = Executors.newCachedThreadPool();
    public static ForumFragment newInstance() {
        return new ForumFragment();
    }

    SwipeRefreshLayout swipeRefreshLayout;
    NetworkUtils network;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.forum_fragment, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ViewModel = new ViewModelProvider(this).get(ForumViewModel.class);
        // TODO: Use the ViewModel
        network = NetworkUtils.getInstance(getContext());
        Log.d(TAG, "onActivityCreated: " + network.client);
        swipeRefreshLayout = getView().findViewById(R.id.swipeRefreshLayout);
        forumRecyclerView = getView().findViewById(R.id.forumRecyclerView);

        forumAdapter = new ForumAdapter();
        forumRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        forumRecyclerView.setAdapter(forumAdapter);

        swipeRefreshLayout.setColorSchemeColors(Color.parseColor("#1E96F2"), Color.parseColor("#BBE2F3"), Color.parseColor("#42BAE4"));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                GetData();
            }
        });

        Log.d(TAG, "onActivityCreated: ??????RecyclerView??????item?????????" + forumAdapter.getItemCount());
        if(forumAdapter.getItemCount() == 0){
            swipeRefreshLayout.setRefreshing(true);
            GetData();
        }


    }

    void GetData(){
        Log.d(TAG, "GetData: ????????????????????????......");
        
        Request request = new Request.Builder()
                .url("https://rexwear.cn/index.php?api/nodes")
                .method("GET", null)
                .addHeader("User-Agent", "ReXAppAndroid/JavaOkHttpRequested")
                .addHeader("XF-API-Key", "x3KEr7kI-ZOrNOjN46HAkB0oGgqHkXLt")
                //.addHeader("XF-Api-User", "37")
                .build();
        network.client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                if(e instanceof SocketTimeoutException){//??????????????????
                    Log.d(TAG, "onFailure: ");
                    Looper.prepare();
                    Toast.makeText(getContext(), "?????????????????????", Toast.LENGTH_LONG).show();
                    swipeRefreshLayout.setRefreshing(false);
                    Looper.loop();
                }
                if(e instanceof ConnectException){//????????????????????????????????????Failed to connect to 10.7.5.144
                    Log.d(TAG, "onFailure: ");
                    Looper.prepare();
                    Toast.makeText(getContext(), "?????????????????????????????????????????????", Toast.LENGTH_LONG).show();
                    swipeRefreshLayout.setRefreshing(false);
                    Looper.loop();
                }


            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String resultJson = response.body().string();
                //Log.d(TAG, "onResponse: " + resultJson);

                NodeBean responseResult = NodeBean.objectFromData(resultJson);
                List<NodeBean.NodesDTO> resultList = responseResult.nodes;
                List<NodeBean.NodesDTO> finalList = new ArrayList<>();

                for (int i = 0; i < resultList.size(); i++) {
                    if(resultList.get(i).nodeTypeId.equals("Forum")){
                        finalList.add(resultList.get(i));
                    }
                    else {
                        Log.d(TAG, "onResponse: ???Node??????Forum??????????????????" + resultList.get(i).title + ",???????????????" + resultList.get(i).nodeTypeId);
                    }
                }
                /*forumAdapter.setNodesList(resultList);
                forumAdapter.notifyDataSetChanged();*/

                UpdateRecyclerView(finalList);

                /*//Log.d(TAG, "onResponse: "+responseResult.nodes);
                Log.d(TAG, "onResponse: ------------------RESULTS------------------");
                for (int i = 0; i < resultList.size(); i++) {
                    Log.d(TAG, "onResponse: node no." + i + ":" + resultList.get(i).title + "description: " + resultList.get(i).description);
                }
                Log.d(TAG, "onResponse: ------------------RESULTS------------------");*/
                Log.d(TAG, "onResponse: ???????????????????????????");
                Looper.prepare();
                swipeRefreshLayout.setRefreshing(false);
                Looper.loop();

            }
        });
    }

    void UpdateRecyclerView(List<NodeBean.NodesDTO> resultList){
        mThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                if(getActivity() != null){
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            forumAdapter.setNodesList(resultList);
                            forumAdapter.notifyDataSetChanged();
                        }
                    });
                }

            }
        });
    }

}