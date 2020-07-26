package com.example.sample_app;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;


public class MainActivity extends AppCompatActivity {
Button  btn_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         btn_submit = (Button)findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Second_screen.class);
                startActivity(intent);
            }
        });
    }
}