package com.example.calendar25082020;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button mBtnDatePicker,mBtnTimePicker;
    TextView mTvDate,mTvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnDatePicker = findViewById(R.id.buttonDatePicker);
        mBtnTimePicker = findViewById(R.id.buttonTimePicker);
        mTvDate = findViewById(R.id.textViewDate);
        mTvTime = findViewById(R.id.textViewTime);

        Calendar calendar = Calendar.getInstance();
        long time = calendar.getTimeInMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Toast.makeText(this, simpleDateFormat.format(time), Toast.LENGTH_SHORT).show();


        mBtnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
                int monthCurrent = Calendar.getInstance().get(Calendar.MONTH);
                int dayCurrent = Calendar.getInstance().get(Calendar.DATE);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        mTvDate.setText("Ngày lựa chọn : " + dayOfMonth + "/" + (month + 1)+ "/" + year);
                    }
                }, yearCurrent, monthCurrent, dayCurrent);
                datePickerDialog.getDatePicker().setMinDate(Calendar.getInstance().getTimeInMillis() - (24 * 60 * 60 * 1000));
                datePickerDialog.show();


            }
        });

        mBtnTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hours = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                int minutes = Calendar.getInstance().get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if (minute < 10){
                            mTvTime.setText("Thời gian : " + hourOfDay +":" + "0" +minute);
                            return;
                        }
                        mTvTime.setText("Thời gian : " + hourOfDay +":" + minute);
                    }
                },hours , minutes,true);
                timePickerDialog.show();
            }
        });

    }
}