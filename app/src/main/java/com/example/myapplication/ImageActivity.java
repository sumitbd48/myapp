package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

public class ImageActivity extends AppCompatActivity implements View.OnClickListener {

    RadioButton radioButton1,radioButton2,radioButton3;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        radioButton1 = findViewById(R.id.rbBird);
        radioButton2 = findViewById(R.id.rbTiger);
        radioButton3 = findViewById(R.id.rbSnake);
        imageView = findViewById(R.id.ivShowing);

        radioButton1.setOnClickListener(this);
        radioButton2.setOnClickListener(this);
        radioButton3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rbBird :
                imageView.setImageResource(R.drawable.bird);
                break;

            case R.id.rbTiger :
                imageView.setImageResource(R.drawable.tiger);
                break;

            case R.id.rbSnake :
                imageView.setImageResource(R.drawable.snake);
                break;
        }
    }
}
