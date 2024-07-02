package com.kotlintask.interviewtask;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

    private final int gridSize;
    private int clickCount = 0; // Count the number of clicks

    public GridAdapter(int gridSize) {
        this.gridSize = gridSize;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int row = position / gridSize;
        int column = position % gridSize;
        holder.textViewItem.setText("[" + row + "," + column + "]");

        holder.textViewItem.setBackgroundColor(Color.WHITE);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = (clickCount % 2 == 0) ? Color.RED : Color.GREEN;
                holder.textViewItem.setBackgroundColor(color); // Set the background color
                clickCount++; // Increment click count
            }
        });
    }

    @Override
    public int getItemCount() {
        return gridSize * gridSize;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewItem;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewItem = itemView.findViewById(R.id.textViewItem);
        }
    }
}