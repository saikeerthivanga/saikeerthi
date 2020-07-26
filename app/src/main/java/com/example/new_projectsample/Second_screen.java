package com.example.new_projectsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Second_screen extends AppCompatActivity {
private TextView text,text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);


        text = (TextView) findViewById(R.id.tv_name);
        text1= (TextView) findViewById(R.id.password);

        Intent intent=getIntent();
        String str = intent.getStringExtra("username");
        String str_pass = intent.getStringExtra("password");
        text.setText(str);
        text1.setText(str_pass);
        Log.d("hello",str);
    }
}