package com.mfr414.daftarmahasiswa;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private List<Student> students;
    private Context context;

    public void setListener(onAdapterClickListener listener) {
        this.listener = listener;
    }

    public onAdapterClickListener listener;

    public StudentAdapter(List<Student> students, Context context, onAdapterClickListener listener) {
        this.students = students;
        this.context = context;
        this.listener= listener;
    }

    public StudentAdapter(List<Student> students,Context context){
        this(students,context,null);
    }


    public interface onAdapterClickListener{
        void onClick(Student student);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_student, viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Student student = students.get(i);
        viewHolder.nameText.setText(student.getName());
        viewHolder.idText.setText(student.getId());
    }

    @Override
    public int getItemCount() {
        return (students != null) ? students.size(): 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameText;
        TextView idText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.text_name);
            idText = itemView.findViewById(R.id.text_id);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Student student= students.get(getAdapterPosition());
                    Toast.makeText(context,student.getName(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
