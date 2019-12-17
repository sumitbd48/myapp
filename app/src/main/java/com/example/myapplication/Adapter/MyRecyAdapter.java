package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Database.DBHelper;
import com.example.myapplication.R;
import com.example.myapplication.UpdateStudentsActivity;
import com.example.myapplication.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MyRecyAdapter extends RecyclerView.Adapter<MyRecyAdapter.MiHolder> {

    private List<Student> studentList = new ArrayList<>();
    private Context context;

    public MyRecyAdapter(List<Student> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyRecyAdapter.MiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_student_rv,parent,false);
        MiHolder miHolder = new MiHolder(view);
        return miHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyAdapter.MiHolder holder, final int position) {
        final Student student = studentList.get(position);
        holder.tvName.setText(student.getName());
        holder.tvEmail.setText(student.getEmail());
        holder.tvPhone.setText(student.getPhone());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbHelper = new DBHelper(context);
                dbHelper.deleteStudents(student.getId());
                studentList.remove(position);
                notifyDataSetChanged();
            }
        });

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,UpdateStudentsActivity.class);
                intent.putExtra("id",String.valueOf(student.getId()));
                intent.putExtra("name",String.valueOf(student.getName()));
                intent.putExtra("email",String.valueOf(student.getEmail()));
                intent.putExtra("phone",String.valueOf(student.getPhone()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }


    public class MiHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvEmail, tvPhone;
        Button btnDelete, btnEdit;

        public MiHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            btnEdit = itemView.findViewById(R.id.btnEdit);
        }
    }
}

