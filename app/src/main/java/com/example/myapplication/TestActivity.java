package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {

    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        radioGroup = findViewById(R.id.rgSubject);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rbAn){
                    Toast.makeText(TestActivity.this, "Android", Toast.LENGTH_SHORT).show();
                }

                if(checkedId == R.id.rbWeb){
                    Toast.makeText(TestActivity.this, "Web", Toast.LENGTH_SHORT).show();
                }

                if (checkedId ==R.id.rbIOT){
                    Toast.makeText(TestActivity.this, "IOT", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
