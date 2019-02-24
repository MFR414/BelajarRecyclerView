package com.mfr414.daftarmahasiswa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements StudentAdapter.onAdapterClickListener{

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_students);
        List<Student> students = new ArrayList<>();
        students.add(new Student("Rifai","123"));
        students.add(new Student("Kiki","124"));
        students.add(new Student("Danin","125"));
        students.add(new Student("Ichsan","126"));
        students.add(new Student("Deby","127"));

        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);
        StudentAdapter studentAdapter = new StudentAdapter(students,this,this);
        studentAdapter.setListener(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(studentAdapter);
    }

    @Override
    public void onClick(Student student) {
    }
}
