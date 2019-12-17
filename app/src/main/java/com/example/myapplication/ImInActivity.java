package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Random;

public class ImInActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCamera, btnUrl, btnGallery, btnDial;
    EditText etPhn;
    ImageView imageView;
    Bitmap image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_im_in);

        btnCamera = findViewById(R.id.btnCamera);
        btnUrl = findViewById(R.id.btnUrl);
        btnGallery = findViewById(R.id.btnGallery);
        btnDial = findViewById(R.id.btnDial);
        etPhn = findViewById(R.id.etPhn);
        imageView = findViewById(R.id.imageView);

        btnCamera.setOnClickListener(this);
        btnUrl.setOnClickListener(this);
        btnGallery.setOnClickListener(this);
        btnDial.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCamera:
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePictureIntent, 1);
                break;

            case R.id.btnUrl:
                String url = "http://www.softwarica.edu.np";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;

            case R.id.btnGallery:
                Intent intent2 = new Intent();
                intent2.setAction(android.content.Intent.ACTION_GET_CONTENT);
                intent2.setType("image/*");
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivityForResult(intent2,2);
                break;

            case R.id.btnDial:
                Uri uri = Uri.parse("tel:"+ etPhn.getText().toString());
                Intent intent3 = new Intent(Intent.ACTION_DIAL,uri);
                startActivityForResult(intent3,3);

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode ==1){
            Bitmap image = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(image);
            askPermission();
        }

        if (requestCode ==2){
            Bitmap image = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(image);
        }
    }

    private void saveCapImg(){
        try{
            File mydir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"Myapp");
            mydir.mkdir();
            Random random = new Random();
            int a = random.nextInt(1000);
            File file = new File(mydir,"myimg"+a+".jpg");
            FileOutputStream fos = new FileOutputStream(file);
            image.compress(Bitmap.CompressFormat.PNG,100,fos);
            Toast.makeText(this, "Saved To"+ mydir, Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            Log.d("myexcep", e.toString());
        }
    }

    public void askPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
        else {
            saveCapImg();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1){
            if (grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                saveCapImg();
            }
            else {
                Toast.makeText(this, "No permission!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
