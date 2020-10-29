package com.example.calendar25082020;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button mBtnDatePicker;
    TextView mTvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnDatePicker = findViewById(R.id.buttonDatePicker);
        mTvDate = findViewById(R.id.textViewDate);

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
                datePickerDialog.show();

            }
        });

    }
}