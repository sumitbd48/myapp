package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class RegdataActivity extends AppCompatActivity {

    TextView textViewName, textViewGender, textViewPradesh, textViewHobbiesOne, textViewHobbiesTwo, textViewHobbiesThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regdata);

        textViewName = findViewById(R.id.textViewName);
        textViewGender = findViewById(R.id.textViewGender);
        textViewPradesh = findViewById(R.id.textViewPradesh);
        textViewHobbiesOne = findViewById(R.id.textViewHobbiesOne);
        textViewHobbiesTwo = findViewById(R.id.textViewHobbiesTwo);
        textViewHobbiesThree = findViewById(R.id.textViewHobbiesThree);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String gender = intent.getStringExtra("gender");
        String pradesh = intent.getStringExtra("pradesh");
        String[] hob = intent.getStringArrayExtra("hob");
//        Toast.makeText(this, name + pradesh + hob[0] + hob[1] + hob[2], Toast.LENGTH_SHORT).show();

        textViewName.setText("Name:" +name);
        textViewGender.setText("Gender:" +gender);
        textViewPradesh.setText("Pradesh:" +pradesh);
        textViewHobbiesOne.setText("Hobbies:" +hob[0]);
        textViewHobbiesTwo.setText("Hobbies:" +hob[1]);
        textViewHobbiesThree.setText("Hobbies:" +hob[2]);
    }
}
