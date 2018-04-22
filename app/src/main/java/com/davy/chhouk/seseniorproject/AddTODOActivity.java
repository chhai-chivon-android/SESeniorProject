package com.davy.chhouk.seseniorproject;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.davy.chhouk.seseniorproject.model.Todo;

import java.util.Calendar;
import java.util.Date;

public class AddTODOActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etTitle;
    EditText etMr1;
    EditText etMr2;
    TextView txtDate;
    TextView txtTime;
    Button pickDate;
    Button pickTime;

    private int mYear = 2018;
    private int mMonth = 4;
    private int mDay = 22;
    private int mHour = 18;
    private int mMinute = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        etTitle = findViewById(R.id.et_title);
        etMr1 = findViewById(R.id.et_mr1);
        etMr2 = findViewById(R.id.et_mr2);
        txtDate = findViewById(R.id.date);
        txtTime = findViewById(R.id.time);
        pickDate = findViewById(R.id.datepicker);
        pickTime = findViewById(R.id.timepicker);

        pickDate.setOnClickListener(this);
        pickTime.setOnClickListener(this);
    }

    public void addTodo(View view) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("title", etTitle.getText().toString());
        returnIntent.putExtra("who", getWho(etMr1.getText().toString(), etMr2.getText().toString()));
        returnIntent.putExtra("year", mYear);
        returnIntent.putExtra("month", (mMonth + 1));
        returnIntent.putExtra("day", mDay);
        returnIntent.putExtra("hour", mHour);
        returnIntent.putExtra("minute", mMinute);

        System.out.println("PASSING: " + mYear);
        System.out.println("PASSING: " + (mMonth + 1));
        System.out.println("PASSING: " + mDay);
        System.out.println("PASSING: " + mHour);
        System.out.println("PASSING: " + mMinute);

        setResult(RESULT_OK, returnIntent);
        finish();
    }

    private String getWho(String mr1, String mr2) {
        if (mr2.equalsIgnoreCase("")) {
            return mr1;
        } else {
            return mr1 + " & " + mr2;
        }
    }

    @Override
    public void onClick(View v) {
        if (v == pickDate) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            mYear = year;
                            mMonth = monthOfYear;
                            mDay = dayOfMonth;
                            txtDate.setText(String.format("%02d", dayOfMonth) + "/" + String.format("%02d", (monthOfYear + 1)) + "/" + year);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == pickTime) {

            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            mHour = hourOfDay;
                            mMinute = minute;
                            txtTime.setText(String.format("%02d", hourOfDay) + ":" + String.format("%02d", minute));
                        }
                    }, mHour, mMinute, true);
            timePickerDialog.show();
        }
    }
}
