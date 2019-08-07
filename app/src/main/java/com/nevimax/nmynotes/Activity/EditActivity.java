package com.nevimax.nmynotes.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.nevimax.nmynotes.BD.AppDatabase;
import com.nevimax.nmynotes.BD.Employee;
import com.nevimax.nmynotes.BD.EmployeeDao;
import com.nevimax.nmynotes.R;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {

    private AppDatabase appDatabase;
    Employee employee;
    EditText zagEd, textEd;
    TextView timeEd;
    String zag, text, time;
    int i =0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Intent intent = getIntent();
        String messZag = intent.getStringExtra("Name");
        String messTex = intent.getStringExtra("Text");
        String messTim = intent.getStringExtra("Time");
        String messid = intent.getStringExtra("id");

        i = Integer.parseInt(messid);

        zagEd = findViewById(R.id.zagolEdfrag);
        textEd = findViewById(R.id.textEdfrag);
        timeEd = findViewById(R.id.dateTimeViewfrag);
        zagEd.setText(messZag);
        textEd.setText(messTex);
        timeEd.setText(messTim);
        appDatabase = AppDatabase.App.getInstance(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.deleteButtonfrag:
                emp();
                appDatabase.employeeDao().delete(employee);
                Toast.makeText(getApplicationContext(),"Удалено", Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.saveButtonfrag:
                emp();
                appDatabase.employeeDao().update(employee);
                Toast.makeText(getApplicationContext(),"Сохранено", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }

    public void emp() {

        zag = zagEd.getText().toString();
        text = textEd.getText().toString();
        time = timeEd.getText().toString();
        employee = new Employee(zag, text, time);
        employee.setId(i);

    }
}
