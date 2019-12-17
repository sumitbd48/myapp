package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Form extends AppCompatActivity {

    EditText editText;
    RadioButton RBMale, RBFemale, RBOthers;
    Spinner Spinner;
    CheckBox CBDance, CBSing, CBRead;
    Button btnSubmit;
    RadioGroup RG;

    String name, gender, pradesh;
    String[] hob = new String[3];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        editText = findViewById(R.id.editText);
        RBMale = findViewById(R.id.RBMale);
        RBFemale = findViewById(R.id.RBFemale);
        RBOthers = findViewById(R.id.RBOthers);
        CBDance = findViewById(R.id.CBDance);
        CBSing = findViewById(R.id.CBSing);
        CBRead = findViewById(R.id.CBRead);
        Spinner = findViewById(R.id.Spinner);
        btnSubmit = findViewById(R.id.btnSubmit);
        RG = findViewById(R.id.RG);

        onCBSelect();
        onSpinnerSelect();
        onGenderSelect();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editText.getText().toString();
                Intent intent = new Intent(Form.this,
                        RegdataActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("gender", gender);
                intent.putExtra("pradesh",pradesh);
                intent.putExtra("hobbies", hob);
                startActivity(intent);

            }
        });

    }

    private void onSpinnerSelect(){
        Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(Form.this,
//                        parent.getSelectedItem().toString(),
//                        Toast.LENGTH_SHORT).show();

                pradesh = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Form.this,
                        "Select One",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void onCBSelect(){
        CBDance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
//                    Toast.makeText(Form.this, "Dancing Checked", Toast.LENGTH_SHORT).show();
                    hob[0] = CBDance.getText().toString();
                }
                else{
//                    Toast.makeText(Form.this, "Dancing Unchecked", Toast.LENGTH_SHORT).show();
                    hob[0] = "";
                }
            }
        });

        CBSing.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
//                    Toast.makeText(Form.this, "Singing Checked", Toast.LENGTH_SHORT).show();
                    hob[1] = CBSing.getText().toString();
                }
                else{
//                    Toast.makeText(Form.this, "Singing Unchecked", Toast.LENGTH_SHORT).show();
                    hob[1] = "";
                }
            }
        });

        CBRead.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
//                    Toast.makeText(Form.this, "Reading Checked", Toast.LENGTH_SHORT).show();
                    hob[2] = CBRead.getText().toString();
                }
                else{
//                    Toast.makeText(Form.this, "Reading Unchecked", Toast.LENGTH_SHORT).show();
                    hob[2] = "";
                }

            }
        });

    }

    private void onGenderSelect(){
        RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.RBMale){
                    gender = "Male";
                }
                else if (checkedId == R.id.RBFemale){
                    gender = "Female";
                }
                else if (checkedId == R.id.RBOthers){
                    gender = "Others";
                }
            }
        });
    }
}
