package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText numFirst, numSec;
    TextView textViewResult;
    Button buttonAdd,buttonSub,buttonMul,buttonDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tbtest);

        numFirst = findViewById(R.id.firstNum);
        numSec = findViewById(R.id.secNum);
        textViewResult = findViewById(R.id.tvResult);
        buttonAdd = findViewById(R.id.btnAdd);
        buttonSub = findViewById(R.id.btnSub);
        buttonMul = findViewById(R.id.btnMul);
        buttonDiv = findViewById(R.id.btnDiv);

        buttonAdd.setOnClickListener(this);

//-----------------------First Way ---------------------------------------
//        buttonAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int a = Integer.parseInt(numFirst.getText().toString());
//                int b = Integer.parseInt(numSec.getText().toString());
//                int c = a + b;
//                textViewResult.setText(String.valueOf(c));
//            }
//        });
//
//        buttonSub.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int a = Integer.parseInt(numFirst.getText().toString());
//                int b = Integer.parseInt(numSec.getText().toString());
//                int c = a - b;
//                textViewResult.setText(String.valueOf(c));
//            }
//        });
//
//        buttonMul.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int a = Integer.parseInt(numFirst.getText().toString());
//                int b = Integer.parseInt(numSec.getText().toString());
//                int c = a * b;
//                textViewResult.setText(String.valueOf(c));
//            }
//        });
//
//        buttonDiv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int a = Integer.parseInt(numFirst.getText().toString());
//                int b = Integer.parseInt(numSec.getText().toString());
//                int c = a / b;
//                textViewResult.setText(String.valueOf(c));
//            }
//        });


    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnAdd)
        {
            int a = Integer.parseInt(numFirst.getText().toString());
            int b = Integer.parseInt(numSec.getText().toString());
            int c = a+b;
            textViewResult.setText("Result: "+ String.valueOf(c));
        }
    }
}
