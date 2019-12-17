package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.myapplication.model.Food;

import java.util.ArrayList;
import java.util.List;

public class RvActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Food> foods = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);

        recyclerView = findViewById(R.id.rvFoods);

        getData();

        MyRvAdapter adapter = new MyRvAdapter(foods,this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void getData(){
        foods.add(new Food("Pizza","Chicken","Rs.300",R.drawable.pizza));
        foods.add(new Food("Waffle","Choclate","Rs.250",R.drawable.waffel));
        foods.add(new Food("Katti Roll","Chicken","Rs.200",R.drawable.roll));
        foods.add(new Food("Pizza","Chicken","Rs.300",R.drawable.pizza));
        foods.add(new Food("Waffle","Choclate","Rs.250",R.drawable.waffel));
        foods.add(new Food("Katti Roll","Chicken","Rs.200",R.drawable.roll));
    }
}
