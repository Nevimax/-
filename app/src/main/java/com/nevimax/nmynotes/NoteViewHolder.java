package com.nevimax.nmynotes;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteViewHolder extends RecyclerView.ViewHolder {
    TextView tvName;
    TextView tvTime;
    TextView tvText;

    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tv_name);
        tvTime = itemView.findViewById(R.id.tv_time);
        tvText = itemView.findViewById(R.id.tv_text);
    }
}
