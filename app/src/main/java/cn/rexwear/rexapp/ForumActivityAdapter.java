package cn.rexwear.rexapp;

import static cn.rexwear.rexapp.ForumFragment.TAG;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.rexwear.rexapp.javabeans.ForumBean;

public class ForumActivityAdapter extends RecyclerView.Adapter<ForumActivityAdapter.ForumViewHolder> {
    List<ForumBean.ThreadsDTO> threadsList = new ArrayList<>();

    public void setThreadsList(List<ForumBean.ThreadsDTO> threadsList) {
        this.threadsList = threadsList;
    }

    @NonNull
    @Override
    public ForumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View item = inflater.inflate(R.layout.cell_thread, parent, false);

        ForumViewHolder viewHolder = new ForumViewHolder(item);


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: ");
                //Uri uri = Uri.parse("https://rexwear.cn/index.php?forums/" + viewHolder.forumId.getText());
                //Intent intent = new Intent(Intent.ACTION_VIEW);
                //intent.setData(uri);
                //viewHolder.itemView.getContext().startActivity(intent);
            }
        });
        return viewHolder;
        //return new ForumViewHolder(item);
        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ForumViewHolder holder, int position) {
        ForumBean.ThreadsDTO thread = threadsList.get(position);
        holder.threadId.setText(thread.threadId.toString());
        holder.threadName.setText(thread.title);
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        String postTimeStamp = thread.postDate + "000";
        String lastPostTimeStamp = thread.lastPostDate + "000";
        Long postTime = Long.valueOf(postTimeStamp);
        Long lastPostTime = Long.valueOf(lastPostTimeStamp);
        Date postDate = new Date(postTime);
        Date lastPostDate = new Date(lastPostTime);
        String postDateString = format.format(postDate);
        String lastPostDateString = format.format(lastPostDate);

        holder.viewCount.setText(thread.viewCount.toString() + "个人浏览过");
        holder.lastPostInfo.setText("最后由 " + thread.lastPostUsername + " 回复于" + lastPostDateString);
        holder.posterName.setText(thread.username + " 发布于" + postDateString);
    }

    @Override
    public int getItemCount() {
        return threadsList.size();
    }

    static class ForumViewHolder extends RecyclerView.ViewHolder {
        TextView threadName, posterName, lastPostInfo, viewCount,threadId;
        ImageView unreadIndicator;
        public ForumViewHolder(@NonNull View itemView) {
            super(itemView);
            threadName = itemView.findViewById(R.id.threadName);
            posterName = itemView.findViewById(R.id.posterName);
            unreadIndicator = itemView.findViewById(R.id.isUnreadIndicator);
            lastPostInfo = itemView.findViewById(R.id.lastPostInfo);
            viewCount = itemView.findViewById(R.id.viewCount);
            threadId = itemView.findViewById(R.id.threadID);
        }
    }
}
