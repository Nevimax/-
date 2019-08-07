package com.nevimax.nmynotes.Activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nevimax.nmynotes.BD.AppDatabase;
import com.nevimax.nmynotes.BD.Employee;
import com.nevimax.nmynotes.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NoteActivity extends AppCompatActivity {

    TextView time, date;
    EditText zag, text;
    ImageButton plus;
    private AppDatabase appDatabase;
    Employee employee;
    Context mcontext;

    @Override
    protected void onPause() {
        super.onPause();
//        appDatabase.employeeDao().update(employee);
        Log.d("NLog","OnStop");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_activity);
        time();

        zag = findViewById(R.id.zagolEd);
        text = findViewById(R.id.textEd);
        date = findViewById(R.id.dateTimeView);
        plus = findViewById(R.id.saveButton);

        appDatabase = AppDatabase.App.getInstance(this);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String zagSt = zag.getText().toString();
                String textSt = text.getText().toString();
                String dateSt = date.getText().toString();

                employee = new Employee(zagSt, textSt, dateSt);
//                if(zagSt.equals(null)){}
                appDatabase.employeeDao().insert(employee);
                Log.d("NLog", "insert");
                Toast.makeText(getApplicationContext(),"Добавлено", Toast.LENGTH_SHORT).show();
                finish();


            }
        });


    }
    public void time(){
        //time
        Date time1 = new Date();
        DateFormat timeFormat = new SimpleDateFormat("HH.mm ");
        String timeText = timeFormat.format(time1);
        //date
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String dateText = dateFormat.format(time1);
        time = findViewById(R.id.dateTimeView);
        time.setText(timeText + "|| " + dateText);
    }

}
