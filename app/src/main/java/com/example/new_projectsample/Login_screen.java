package com.example.new_projectsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login_screen extends AppCompatActivity {

    private EditText etusename,etpassword;
    private Button btn_submit,btn_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        etusename = findViewById(R.id.cisf_id);
        etpassword= findViewById(R.id.password);
        btn_submit= findViewById(R.id.btn_submit);
        btn_register=findViewById(R.id.btn_register);


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_username = etusename.getText().toString();
                String str_password = etpassword.getText().toString();
                Log.d("username", str_username + "\n" + str_password);

                if (etusename.getText().toString().trim().length() == 0) {
                    etusename.setError("Please enter username");
                    etusename.requestFocus();

                } else if (etpassword.getText().toString().trim().length() == 0) {
                    etpassword.setError("Please enter password");
                    etpassword.requestFocus();
                } else {
                    Intent intent = new Intent(Login_screen.this, Second_screen.class);
                    intent.putExtra("username", str_username);
                    intent.putExtra("password", str_password);
                    startActivity(intent);
                }
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login_screen.this,Register_page.class);
                startActivity(intent);
            }
        });
    }
}