package com.nevimax.nmynotes.Recycler;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nevimax.nmynotes.BD.Employee;
import com.nevimax.nmynotes.R;

import java.util.List;


public class NoteRecyclerAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    private List<Employee> noteModels;


    public NoteRecyclerAdapter(List<Employee> noteModels) {
        this.noteModels = noteModels;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("Nholder", "onCreateViewHolder");
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_activity,
                                parent, false);
        return new NoteViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final NoteViewHolder holder, int position) {
        final NoteViewHolder viewHolder = holder;
        Log.d("Nholder", "onBindViewHolder");
        viewHolder.tvName.setText(noteModels.get(position).getZagol());
        viewHolder.tvTime.setText(noteModels.get(position).getDate());
        viewHolder.tvText.setText(noteModels.get(position).getText());


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("NLog", "OnClickAdapter");
//                Intent intent = new Intent(Ma);
//                startActivity(intent);
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.d("NLog", "OnLongClickAdapter");
                return true;
            }
        });
    }


    @Override
    public int getItemCount() {
        Log.d("Nholder", "getItemCountAdapter");
        return noteModels.size();
    }


}
