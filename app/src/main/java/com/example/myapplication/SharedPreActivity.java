package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class SharedPreActivity extends AppCompatActivity {

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pre);

        sp = getApplicationContext().getSharedPreferences("mysp",MODE_PRIVATE);
//        editor = sp.edit();
//        editor.putString("name","Sumit");
//        editor.putInt("age",22);
//        editor.putBoolean("isMember",true);
//        editor.commit();

        String n = sp.getString("name","");
        int a = sp.getInt("age",0);
        boolean im = sp.getBoolean("isMember",false);
        int b = sp.getInt("zip",0);
        String test = sp.getString("Address","Nepal");

        Toast.makeText(this, "Name: " +n +"\n"
                +"Age: "+ a +"\n"
                +"Member: "+ im +"\n"
                +"zip: "+ b +"\n"
                +"Address:"+ test, Toast.LENGTH_SHORT).show();
    }
}
