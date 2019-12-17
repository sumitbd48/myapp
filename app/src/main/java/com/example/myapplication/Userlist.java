package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.model.User;

import java.util.List;

public class Userlist extends AppCompatActivity {

    ListView listView;
    String[] test = {"a","b","C"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);

        listView = findViewById(R.id.lvUsers);

        Intent intent = getIntent();
        final List<User> userList = (List<User>) intent.getSerializableExtra("allusers");
        String[] userNames = new String[userList.size()];

        int i = 0;
        for (User user:userList){
            userNames[i] = user.getName();
            i++;
        }

        final ArrayAdapter adapter = new ArrayAdapter(this,R.layout.spinner_values,userNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent(Userlist.this,UserDetail.class);
                intent1.putExtra("Name",userList.get(position).getName());
                intent1.putExtra("Gender",userList.get(position).getGender());
                intent1.putExtra("DoB",userList.get(position).getDob());
                intent1.putExtra("Country",userList.get(position).getCountry());
                intent1.putExtra("Phone",userList.get(position).getPhone());
                intent1.putExtra("Email",userList.get(position).getEmail());
                startActivity(intent1);
            }
        });
    }
}
