package com.example.knocktime;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class addtask extends AppCompatActivity{

    TextView judul, adddate, addtitle;
    EditText maintitle, maintime, maindate;
    Button btnsave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addtask);

        judul = findViewById(R.id.judul);



        addtitle = findViewById(R.id.addtitle);
        adddate = findViewById(R.id.adddate);
        addtitle = findViewById(R.id.addtitle);


        maintitle = findViewById(R.id.maintitle);
        maindate = findViewById(R.id.maindate);
        maintime = findViewById(R.id.maintime);


        btnsave = findViewById(R.id.btnsave);

        maindate.setInputType(InputType.TYPE_NULL);
        maintime.setInputType(InputType.TYPE_NULL);

        maindate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(maindate);
            }
        });

        maintime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimeDialog(maintime);
            }
        });



        Intent intent = getIntent();


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(addtask.this, MainActivity.class);
                startActivity(i);
            }
        });

    }


    private void showTimeDialog(final EditText maintime) {
        final Calendar calendar=Calendar.getInstance();

        TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                calendar.set(Calendar.MINUTE,minute);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm");
                maintime.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };

        new TimePickerDialog(addtask.this,timeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();
    }

    private void showDateDialog(final EditText maindate) {
        final Calendar calendar=Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yy-MM-dd");
                maindate.setText(simpleDateFormat.format(calendar.getTime()));

            }
        };

        new DatePickerDialog(addtask.this,dateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }


}
