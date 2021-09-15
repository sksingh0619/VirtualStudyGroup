package com.light.nearbyvsg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import com.amulyakhare.textdrawable.TextDrawable;

import java.util.ArrayList;

public class JoinGroup extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Groups> dataSet = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_group);
        Groups g = new Groups("Sudhanshu","Physics","Lights and effects","description");
        dataSet.add(g);
        recyclerView = findViewById(R.id.join_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new GroupAdapter(dataSet));


    }
}