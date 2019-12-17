package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.Adapter.MyRecyAdapter;
import com.example.myapplication.Database.DBHelper;
import com.example.myapplication.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabaseActivity extends AppCompatActivity {

    EditText etName, etEmail, etPhone;
    Button btnSubmit;
    DBHelper dbHelper;
    RecyclerView recyclerView;
    List<Student> std = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        btnSubmit = findViewById(R.id.btnSubmit);

        recyclerView = findViewById(R.id.rvStudents);

        MyRecyAdapter adapter = new MyRecyAdapter(std,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        dbHelper = new DBHelper(this);
        getDetails();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = etName.getText().toString();
                String e = etEmail.getText().toString();
                String p = etPhone.getText().toString();

                Student student = new Student(0,n,e,p);

                if (dbHelper.addStudent(student)){
                    Toast.makeText(DatabaseActivity.this, "Student added!", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        List<Student> students = dbHelper.getStudents();
//        for (Student student:students){
//            Log.d("id:",String.valueOf(student.getId()));
//            Log.d("name:",student.getName());
//            Log.d("email:",student.getEmail());
//            Log.d("phone:",student.getPhone());
//        }
    }

    private void getDetails(){
        List<Student> students = dbHelper.getStudents();
        for (Student student:students){
            std.add(new Student(student.getId(),student.getName(),student.getEmail(),student.getPhone()));
        }
    }
}
