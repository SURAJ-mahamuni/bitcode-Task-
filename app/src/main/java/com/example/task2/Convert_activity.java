package com.example.task2;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Convert_activity extends AppCompatActivity implements View.OnClickListener{
    TextView user_cc,phone_cc,pick_date,pick_time;
    EditText enter_amount;
    Button date_,time_,convert;
    String amount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.convetor_activity);
        initView();
        initListener();
        extraData();
    }
    private void extraData(){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        user_cc.setText(bundle.getString("userN"));
        phone_cc.setText(bundle.getString("phone_"));

    }

    private void initListener() {
        convert.setOnClickListener(this);
        date_.setOnClickListener(this);
        time_.setOnClickListener(this);

    }

    private void initView() {
        user_cc = findViewById(R.id.user_cc);
        phone_cc = findViewById(R.id.phone_cc);
        pick_date = findViewById(R.id.pick_date);
        pick_time = findViewById(R.id.pick_time);
        enter_amount = findViewById(R.id.enter_amount);
        date_ = findViewById(R.id.date_);
        time_ = findViewById(R.id.time_);
        convert = findViewById(R.id.convert);
        amount = enter_amount.getText().toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem menuItem = menu.add(1,1,1,"Setting");
            menu.add(2,2,2,"Logout");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1:
                makeToast1("Setting");
                break;
            case 2:
                makeToast1("Logout");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void makeToast1(String text){
        Toast.makeText(Convert_activity.this,text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        if(view == date_){
            DatePickerDialog datePickerDialog = new DatePickerDialog(Convert_activity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    pick_date.setText(day+"/"+month+"/"+year);
                }
            },2022,11,12);
            datePickerDialog.show();
        }
        if(view == time_){
            TimePickerDialog timePickerDialog = new TimePickerDialog(Convert_activity.this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hour, int min) {
                    pick_time.setText(hour+":"+min);
                }
            },16,29,true);
            timePickerDialog.show();
        }
        if(view == convert){
            Float holder = Float.valueOf(enter_amount.getText().toString());
            ConvertorDialog convertorDialog = new ConvertorDialog(Convert_activity.this,enter_amount.getText().toString());
            convertorDialog.setOnConvertListener(new ConvertorDialog.OnConvertListener() {
                @Override
                public void usa() {
                    String num = String.valueOf(holder*82.0f);
                    enter_amount.setText(num);
                }

                @Override
                public void china() {
                    String num = String.valueOf(holder*0.084f);
                    enter_amount.setText(num);

                }

                @Override
                public void russia() {
                    String num = String.valueOf(holder*0.85f);
                    enter_amount.setText(num);

                }

                @Override
                public void Spain() {
                    String num = String.valueOf(holder*0.011f);
                    enter_amount.setText(num);

                }

                @Override
                public void convert() {
                    convertorDialog.dismiss();
                }
            });
            convertorDialog.show();

        }

    }
}
