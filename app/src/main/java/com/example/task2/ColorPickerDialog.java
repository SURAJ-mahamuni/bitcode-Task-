package com.example.task2;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ColorPickerDialog extends Dialog {
    ListView color_;
    Resources resources;
    String [] coloritem;
    Context context;
    ArrayAdapter<String> stringArrayAdapter;

    public ColorPickerDialog(@NonNull Context context) {
        super(context);
        this.context = context;
        setContentView(R.layout.color_picker_dialog);
        initView();
        resources();
        stringArrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1,coloritem);
        color_.setAdapter(stringArrayAdapter);
    }

    private void resources() {
        resources = 
        coloritem = resources.getStringArray(R.array.color_name);
    }

    private void initView() {
        color_ = findViewById(R.id.color_);
        color_.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(context,coloritem[i],Toast.LENGTH_SHORT).show();
            }
        });

    }
}
