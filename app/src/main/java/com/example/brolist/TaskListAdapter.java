package com.example.brolist;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.brolist.model.TaskModel;

import java.util.ArrayList;
import java.util.Locale;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.ViewHolder> {

    private ArrayList<TaskModel> taskDataset;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView taskNameTv,taskStatusTv;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            taskNameTv = (TextView) view.findViewById(R.id.taskNameTv);
            taskStatusTv = (TextView) view.findViewById(R.id.taskStatusTv);
        }


    }


    public TaskListAdapter(ArrayList<TaskModel> taskDataset) {
        this.taskDataset = taskDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_task, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.taskNameTv.setText(taskDataset.get(position).getTaskName());
        viewHolder.taskStatusTv.setText(taskDataset.get(position).getTaskStatus());

        String status=taskDataset.get(position).getTaskStatus();

        if(status.toLowerCase().equals("pending"))
        {
            viewHolder.taskStatusTv.setBackgroundColor(Color.parseColor("#FFFF00"));

        } else if(status.toLowerCase().equals("completed"))
        {
            viewHolder.taskStatusTv.setBackgroundColor(Color.parseColor("#00FF00"));
        }else{

            viewHolder.taskStatusTv.setBackgroundColor(Color.parseColor("#ffffff"));
        }




    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return taskDataset.size();
    }
}
