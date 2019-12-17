package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class UserDetail extends AppCompatActivity {

    ImageView imageView;
    TextView txtname, txtgender, txtdob, txtcountry, txtphone, txtemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        imageView = findViewById(R.id.imageView);
        txtname = findViewById(R.id.name);
        txtgender = findViewById(R.id.gender);
        txtdob = findViewById(R.id.dob);
        txtcountry = findViewById(R.id.country);
        txtphone = findViewById(R.id.phone);
        txtemail = findViewById(R.id.email);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String gender = intent.getStringExtra("Gender");
        String dob = intent.getStringExtra("DoB");
        String country = intent.getStringExtra("Country");
        String phone = intent.getStringExtra("Phone");
        String email = intent.getStringExtra("Email");

        txtname.setText("Name: "+name);
        txtgender.setText("Gender: "+gender);
        txtdob.setText("DoB: "+dob);
        txtcountry.setText("Country: "+country);
        txtphone.setText("Phone: "+phone);
        txtemail.setText("Email: "+email);

    }
}
