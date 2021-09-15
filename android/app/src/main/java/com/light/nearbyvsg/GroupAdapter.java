package com.light.nearbyvsg;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amulyakhare.textdrawable.TextDrawable;

import java.util.ArrayList;
import java.util.Locale;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder> {

    ArrayList<Groups> groupList = new ArrayList<>();


    public GroupAdapter(ArrayList<Groups> groupList) {
        this.groupList = groupList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView subject, topic, close,subject_desc, topic_desc, description;
        Button join;
        ImageView imageView;
        Dialog dialog;
        LinearLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            subject = itemView.findViewById(R.id.subject_name);
            subject_desc = itemView.findViewById(R.id.subject_desc);
            topic_desc = itemView.findViewById(R.id.topic_desc);
            topic = itemView.findViewById(R.id.topic_name);
            join = itemView.findViewById(R.id.join);
            imageView = itemView.findViewById(R.id.image);
            dialog = new Dialog(itemView.getContext());
            dialog.setContentView(R.layout.group_details);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            close = dialog.findViewById(R.id.close);
            layout = itemView.findViewById(R.id.join_layout);
            description = itemView.findViewById(R.id.description);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.join_item,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.subject.setText(groupList.get(position).getSubject());
        holder.topic.setText(groupList.get(position).getTopic());
        String s = groupList.get(position).name.substring(0,1);
        TextDrawable drawable = TextDrawable.builder().buildRound(s.toUpperCase(Locale.ROOT), Color.RED);
        holder.imageView.setImageDrawable(drawable);
        holder.layout.setOnClickListener(v -> holder.dialog.show());
        holder.close.setOnClickListener(v -> holder.dialog.dismiss());
//        holder.subject_desc.setText(groupList.get(position).getSubject());
//        holder.topic_desc.setText(groupList.get(position).getTopic());
//        holder.description.setText(groupList.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return groupList.size();
    }


}
