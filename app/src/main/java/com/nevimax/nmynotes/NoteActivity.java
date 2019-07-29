package com.nevimax.nmynotes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoteActivity extends AppCompatActivity {

    TextView time, date;
    EditText zag, text;
    ImageButton plus;
    private AppDatabase appDatabase;
    private EmployeeDao notesDao;
    Employee employee;

    @Override
    protected void onPause() {
        super.onPause();
//        appDatabase.employeeDao().update(employee);
        Log.d("QWE","OnStop");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_activity);
        //time
        Date time1 = new Date();
        DateFormat timeFormat = new SimpleDateFormat("HH.mm ");
        String timeText = timeFormat.format(time1);
        //date
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String dateText = dateFormat.format(time1);
        time = findViewById(R.id.dateTimeView);
        time.setText(timeText + "|| " + dateText);

        zag = findViewById(R.id.zagolEd);
        text = findViewById(R.id.textEd);
        date = findViewById(R.id.dateTimeView);
        plus = findViewById(R.id.saveButton);

        appDatabase = App.getInstance(this);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String zagSt = zag.getText().toString();
                String textSt = text.getText().toString();
                String dateSt = date.getText().toString();

                employee = new Employee(zagSt, textSt, dateSt);
                appDatabase.employeeDao().insert(employee);
                Log.d("QWE", "insert");
                finish();

            }
        });


    }

}
