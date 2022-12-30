package cn.rexwear.rexapp;

import static cn.rexwear.rexapp.ForumFragment.TAG;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

import cn.rexwear.rexapp.javabeans.NodeBean;

public class ForumAdapter extends RecyclerView.Adapter<ForumAdapter.ForumViewHolder> {
/*    Context context;

    public ForumAdapter(Context context) {
        this.context = context;
    }*/

    List<NodeBean.NodesDTO> nodesList = new ArrayList<>();

    public void setNodesList(List<NodeBean.NodesDTO> nodesList) {
        this.nodesList = nodesList;
    }

    @NonNull
    @Override
    public ForumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View item = inflater.inflate(R.layout.cell_forums, parent, false);

        ForumViewHolder viewHolder = new ForumViewHolder(item);


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/*                Log.d(TAG, "onClick: ");
                Uri uri = Uri.parse("https://rexwear.cn/index.php?forums/" + viewHolder.forumId.getText());
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                viewHolder.itemView.getContext().startActivity(intent);*/


                Intent intent = new Intent(viewHolder.itemView.getContext(), ForumActivity.class);
                intent.putExtra("forumID", viewHolder.forumId.getText());
                intent.putExtra("forumName", viewHolder.name.getText());
                viewHolder.itemView.getContext().startActivity(intent);
            }
        });
        return viewHolder;
        //return new ForumViewHolder(item);
        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ForumViewHolder holder, int position) {
        NodeBean.NodesDTO node = nodesList.get(position);
        holder.name.setText(node.title);
        holder.desc.setText(node.description);
        holder.forumId.setText(node.nodeId.toString());
        if(node.typeData.discussionCount != 0){
            SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
            String timeStampTXT = node.typeData.lastPostDate + "000";
            //int timeInt = Integer.valueOf(timeStampTXT);
            Long time = Long.valueOf(timeStampTXT);
            //Long time = new Long((long)timeInt);
            Date date = new Date(time);
            String updateTime = format.format(date);
            String updateInfoText = "最后由 " + node.typeData.lastPostUsername + " 更新于" + updateTime + "。";
            holder.updateInfo.setText(updateInfoText);
        }else{
            holder.updateInfo.setText("这里什么都没有哦～");
        }

        if(node.typeData.isUnread){
            holder.unreadIndicator.setVisibility(View.VISIBLE);
        }
        else{
            holder.unreadIndicator.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return nodesList.size();
    }

    static class ForumViewHolder extends RecyclerView.ViewHolder {
        TextView name, desc, updateInfo, forumId;
        ImageView unreadIndicator;
        public ForumViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.forumName);
            desc = itemView.findViewById(R.id.forumDesc);
            updateInfo = itemView.findViewById(R.id.updateInfo);
            unreadIndicator = itemView.findViewById(R.id.isUnreadIndicator);
            forumId = itemView.findViewById(R.id.forumIDtext);
        }
    }
}
