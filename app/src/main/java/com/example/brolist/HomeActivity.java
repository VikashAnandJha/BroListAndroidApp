package com.example.brolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.brolist.model.TaskModel;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView taskRv;
    ArrayList<TaskModel> dataList=new ArrayList<>();
    TaskListAdapter taskListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();


        taskRv=findViewById(R.id.taskListRv);

        dataList.add(new TaskModel("testId","Go to gym","completed"));
        dataList.add(new TaskModel("testId","have lunch","pending"));
        dataList.add(new TaskModel("testId","meet with a friend","completed"));


        taskListAdapter=new TaskListAdapter(dataList);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        taskRv.setLayoutManager(layoutManager);
        taskRv.setAdapter(taskListAdapter);


        findViewById(R.id.addTaskFAB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,AddTaskActivity.class));
            }
        });






    }
}