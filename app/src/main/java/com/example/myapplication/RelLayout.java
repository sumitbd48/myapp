package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class RelLayout extends AppCompatActivity {

    Button btnCLick;
    ImageView ivFlower, ivTree, ivWater, ivBird;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rel_layout);
        btnCLick = findViewById(R.id.btnClick);
        ivFlower = findViewById(R.id.ivFlower);
        ivTree = findViewById(R.id.ivTree);
        ivWater = findViewById(R.id.ivWater);
        ivBird = findViewById(R.id.ivBird);

        btnCLick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter ++;

                if (counter ==1){
                    ivFlower.setVisibility(View.VISIBLE);
                    ivTree.setVisibility(View.INVISIBLE);
                    ivWater.setVisibility(View.INVISIBLE);
                    ivBird.setVisibility(View.INVISIBLE);
                }

                if (counter ==2){
                    ivFlower.setVisibility(View.INVISIBLE);
                    ivTree.setVisibility(View.VISIBLE);
                    ivWater.setVisibility(View.INVISIBLE);
                    ivBird.setVisibility(View.INVISIBLE);
                }

                if (counter ==3){
                    ivFlower.setVisibility(View.INVISIBLE);
                    ivTree.setVisibility(View.INVISIBLE);
                    ivWater.setVisibility(View.VISIBLE);
                    ivBird.setVisibility(View.INVISIBLE);
                }

                if (counter ==4){
                    ivFlower.setVisibility(View.INVISIBLE);
                    ivTree.setVisibility(View.INVISIBLE);
                    ivWater.setVisibility(View.INVISIBLE);
                    ivBird.setVisibility(View.VISIBLE);
                    counter=0;
                }
            }
        });
    }

}
