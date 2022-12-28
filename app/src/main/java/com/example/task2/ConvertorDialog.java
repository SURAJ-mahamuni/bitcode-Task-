package com.example.task2;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class ConvertorDialog extends Dialog implements View.OnClickListener {
    TextView amount,money_;
    RadioGroup radio_g;
    //    RadioButton first_radio,second_radio,third_radio,fourth_radio;
    Button convert1;
    String amount1,hold_value;
    Context context;

    public ConvertorDialog(@NonNull Context context, String amount1) {
        super(context);
        this.amount1 = amount1;
        this.context = context;
        setContentView(R.layout.convetor_dialog);
        initView();
        initListener();
    }

    private OnConvertListener onConvertListener;

    public void setOnConvertListener(OnConvertListener OnConvertListener) {
        this.onConvertListener = OnConvertListener;
    }

    public interface OnConvertListener {
        void usa();

        void china();

        void russia();

        void Spain();

        void convert();
    }

    private void initListener() {
        convert1.setOnClickListener(this);
        amount.setText(amount1);
        radio_g.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.first_radio:
                        hold_value = String.valueOf(Float.parseFloat(amount1) / 82.0f);
                        amount.setText(hold_value);
                        onConvertListener.usa();
                        money_.setText("Doller");
                        break;
                    case R.id.second_radio:
                        hold_value = String.valueOf(Float.parseFloat(amount1) / 0.084f);
                        amount.setText(hold_value);
                        onConvertListener.china();
                        money_.setText("Yuan");
                        break;
                    case R.id.third_radio:
                        hold_value = String.valueOf(Float.parseFloat(amount1) / 0.85f);
                        amount.setText(hold_value);
                        onConvertListener.russia();
                        money_.setText("Ruble");
                        break;
                    case R.id.fourth_radio:
                        hold_value = String.valueOf(Float.parseFloat(amount1) / 0.011f);
                        amount.setText(hold_value);
                        onConvertListener.Spain();
                        money_.setText("Euro");
                        break;
                }
            }
        });
    }

    private void initView() {
        amount = findViewById(R.id.amount);
        radio_g = findViewById(R.id.radio_g);
        convert1 = findViewById(R.id.convert1);
        money_ = findViewById(R.id.money_);

    }

    @Override
    public void onClick(View view) {
        if (view == convert1) {
            onConvertListener.convert();
        }

    }
}
