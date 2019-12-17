package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class activity_file extends AppCompatActivity {

    EditText editText;
    Button btnSave, btnLoad, btnexSave, btnexLoad;
    private ListView lstwm;
    private Map<String, String> myhm = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        lstwm = findViewById(R.id.listView);

        editText = findViewById(R.id.etInput);
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        btnexLoad = findViewById(R.id.exLoad);
        btnexSave = findViewById(R.id.exSave);

        if (isExWritable()) {
            Toast.makeText(this, "True", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "False", Toast.LENGTH_SHORT).show();
        }


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = editText.getText().toString();
                try {
                    FileOutputStream fos = openFileOutput("myfile.txt", MODE_PRIVATE);
                    fos.write(data.getBytes());
                    editText.getText().clear();
                    Toast.makeText(activity_file.this, "Saved to" + getFilesDir(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Log.d("Exc", e.toString());
                }
            }
        });

        lstwm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = myhm.get(parent.getItemAtPosition(position).toString());
                Toast.makeText(activity_file.this, value, Toast.LENGTH_SHORT).show();
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fis = openFileInput("myfile.txt");//finds file
                    InputStreamReader isr = new InputStreamReader(fis);//reads the content of the file
                    BufferedReader br = new BufferedReader(isr);
                    //for appending(adding) the multiline data
//                    StringBuilder sb = new StringBuilder();
//                    String data;
//                    while ((data = br.readLine()) != null){
//                        sb.append(data+ "\n");
//                    }

                    String data;
                    String alldata = "";
                    while ((data = br.readLine()) != null) {
                        //alldata += data + "\n";
                        String[] wm = data.split("=");
                        myhm.put(wm[0], wm[1]);
                    }

                    ArrayAdapter arrayAdapter = new ArrayAdapter(activity_file.this, R.layout.textview, new ArrayList(myhm.keySet()));
                    lstwm.setAdapter(arrayAdapter);
                } catch (Exception e) {
                    Log.d("Exc", e.toString());
                }
            }
        });

        btnexSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askPermission();
                saveExternal();
            }
        });


    }

    private boolean isExWritable() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            return true;
        } else {
            return false;
        }
    }

    public void askPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
        else {
            saveExternal();
        }
    }

    private void saveExternal(){
        if (isExWritable()){
            String data = editText.getText().toString();
            try{
                File mydir = new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS),"Myapp");
                mydir.mkdir();
                File myfile = new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS),"Myapp/myfile.txt");
                myfile.createNewFile();
                FileOutputStream fos = new FileOutputStream(mydir);
                fos.write(data.getBytes());
                editText.getText().clear();
                Toast.makeText(this, "Saved to" +mydir, Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){
                Log.d("myex",e.toString());
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1){
            if (grantResults.length >0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                saveExternal();
            }
            else {
                Toast.makeText(this, "Mo Permission", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
