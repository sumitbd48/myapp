package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class ButtonsActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLL, btnGL, btnRL, btnCL, btnTL, btnFL, btnRv, btntoolbar, btnFile, btnSp, btnImIn, btnWord, btnDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);

        btnLL = findViewById(R.id.btnLL);
        btnGL = findViewById(R.id.btnGL);
        btnRL = findViewById(R.id.btnRL);
        btnCL = findViewById(R.id.btnCL);
        btnTL = findViewById(R.id.btnTL);
        btnFL = findViewById(R.id.btnFL);
        btnRv = findViewById(R.id.RecyclerView);
        btntoolbar = findViewById(R.id.Toolbarbtn);
        btnFile = findViewById(R.id.btnFile);
        btnSp = findViewById(R.id.btnSp);
        btnImIn = findViewById(R.id.btnImIn);
        btnWord = findViewById(R.id.btnWord);
        btnDatabase = findViewById(R.id.btnDatabase);

        btnLL.setOnClickListener(this);
        btnGL.setOnClickListener(this);
        btnRL.setOnClickListener(this);
        btnCL.setOnClickListener(this);
        btnTL.setOnClickListener(this);
        btnFL.setOnClickListener(this);
        btnRv.setOnClickListener(this);
        btntoolbar.setOnClickListener(this);
        btnFile.setOnClickListener(this);
        btnSp.setOnClickListener(this);
        btnImIn.setOnClickListener(this);
        btnWord.setOnClickListener(this);
        btnDatabase.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()== R.id.btnFL){
            Intent intent = new Intent(ButtonsActivity.this, frame_layout.class);
            startActivity(intent);
        }

        if (v.getId()== R.id.btnTL){
            Intent intent = new Intent(ButtonsActivity.this, Table_layout.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.btnLL){
            Intent intent = new Intent(ButtonsActivity.this, LinearLayout.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.btnGL){
            Intent intent = new Intent(ButtonsActivity.this, Calc.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.RecyclerView){
            Intent intent = new Intent(ButtonsActivity.this, RvActivity.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.Toolbarbtn){
            Intent intent = new Intent(ButtonsActivity.this, ToolbarActivity.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.btnFile){
            Intent intent = new Intent(ButtonsActivity.this, activity_file.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.btnSp){
            Intent intent = new Intent(ButtonsActivity.this, SharedPreActivity.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.btnImIn){
            Intent intent = new Intent(ButtonsActivity.this, ImInActivity.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.btnWord){
            Intent intent = new Intent(ButtonsActivity.this, WordActivity.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.btnDatabase){
            Intent intent = new Intent(ButtonsActivity.this, DatabaseActivity.class);
            startActivity(intent);
        }

    }
}
