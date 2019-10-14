package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calc extends AppCompatActivity implements View.OnClickListener{

    EditText editText;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnAdd, btnSub, btnMul, btnDiv, btnClear, btnEq;
    String displayNum = "";
    int num1,num2;
    int res;
    String op;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        editText = findViewById(R.id.editText);
        btnAdd = findViewById(R.id.btnAdd);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn1:
                displayNum += 1;

        }
    }

    private int getResult(String op, int n1, int n2)
    {
        switch (op)
        {
            case "+":
            {
                return n1+n2;
            }

            default:
            {
                return 0;
            }
        }
    }
}
