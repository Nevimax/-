package com.nevimax.nmynotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class NoteRecyclerAdapter  extends RecyclerView.Adapter<NoteViewHolder> {

    private List<Employee> noteModels;// = new ArrayList<>()
//    private OnDeleteListener onDeleteListener;
//    private Context context;

    public NoteRecyclerAdapter(List<Employee> noteModels) {
        this.noteModels = noteModels;
    }

//    public NoteRecyclerAdapter() {
//
//    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_activity,
                                parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        final NoteViewHolder viewHolder = holder;
        viewHolder.tvName.setText(noteModels.get(position).zagol);
        viewHolder.tvTime.setText(noteModels.get(position).date);
        viewHolder.tvText.setText(noteModels.get(position).text);
    }

    @Override
    public int getItemCount() {
        return noteModels.size();
    }

}
