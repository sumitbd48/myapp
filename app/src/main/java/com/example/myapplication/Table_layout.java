package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.model.User;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public class Table_layout extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener{

    CalendarView calenderView;
    EditText Name, DoB, Gender, Country, Phone, Email;
    RadioGroup RG;
    Spinner Spinner;
    Button btnSubmit, btnView;
    String name, gender, dob, country, phone,email;
    String[] countries = {"Nepal","India","Srilanka","Bhutan","Maldives","Myanmar","Pakistan","Afghanistan"};

    List<User> userList = new ArrayList<>(); //class is also called as user defined data type



    Calendar calendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener mydatepicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            calendar.set(Calendar.YEAR,year);
            calendar.set(Calendar.MONTH,month);
            calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
            String mydateFormat = "dd-MM-y";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(mydateFormat, Locale.getDefault());
            DoB.setText(simpleDateFormat.format(calendar.getTime()));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);

        Name = findViewById(R.id.Name);
        DoB = findViewById(R.id.DoB);
        Phone = findViewById(R.id.Phone);
        Email = findViewById(R.id.Email);
        RG = findViewById(R.id.RG);
        Spinner = findViewById(R.id.Spinner);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnView = findViewById(R.id.btnView);
//        calenderView = findViewById(R.id.calenderView);

//        calenderView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
//                String mydate = String.valueOf(calenderView.getDate());
//                Toast.makeText(Table_layout.this, String.valueOf(year)+ "-"+
//                        String.valueOf(month)+ "-"+
//                        String.valueOf(dayOfMonth), Toast.LENGTH_SHORT).show();
//            }
//        });

        ArrayAdapter<String> adapter = new ArrayAdapter(this, R.layout.spinner_values,countries);
        Spinner.setAdapter(adapter);

        RG.setOnCheckedChangeListener(this);
        setSpinnerValue();
        btnSubmit.setOnClickListener(this);
        DoB.setOnClickListener(this);
        btnView.setOnClickListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.RBMale){
            gender = "Male";
        }
        if (checkedId == R.id.RBFemale){
            gender = "Female";
        }
        if (checkedId == R.id.RBOther){
            gender = "Other";
        }
    }

    private void setSpinnerValue(){
        Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                country = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Table_layout.this,
                        "Please select Country",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        name = Name.getText().toString();
        dob = DoB.getText().toString();
        phone = Phone.getText().toString();
        email = Email.getText().toString();

        if (v.getId() == R.id.btnSubmit){
            if (validate()){
                userList.add(new User(name,gender,dob,country,phone,email));
                Toast.makeText(this,"User Added", Toast.LENGTH_SHORT).show();

            }
        }

        if (v.getId() == R.id.DoB){
            new DatePickerDialog(this,mydatepicker,
                    calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
        }

        if (v.getId() == R.id.btnView){
                Intent intent = new Intent(this,Userlist.class);
                intent.putExtra("allusers",(Serializable) userList);
                startActivity(intent);
        }
    }

    private boolean validate(){
        if (TextUtils.isEmpty(name)){
            Name.setError("Enter Name");
            Name.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(dob)){
            DoB.setError("Enter DoB");
            DoB.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(gender)){
            Toast.makeText(this, "Enter Gender", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(country)){
            Country.setError("Enter Country");
            Country.requestFocus();
            return false;
        }
        if (!TextUtils.isDigitsOnly(phone)){
            Phone.setError("Invalid Phone");
            Phone.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(email)){
            Email.setError("Enter Email");
            Email.requestFocus();
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Email.setError("Invalid Email");
            Email.requestFocus();
            return false;
        }

        return true;
    }
}
