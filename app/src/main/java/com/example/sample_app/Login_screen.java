package com.example.sample_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_screen extends AppCompatActivity {

    private EditText etusename,etpassword;
    private Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

         etusename= findViewById(R.id.etusername);
         etpassword= findViewById(R.id.etpassword);
         btn_submit= findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_username=etusename.getText().toString().trim();
                String str_password=etpassword.getText().toString().trim();
                Log.d("username",str_username +"\n"+str_password);

                if (etusename.getText().toString().trim().length()==0){
                    etusename.setError("Please enter username");
                    etusename.requestFocus();

                } else if (etpassword.getText().toString().trim().length()==0){
                    etpassword.setError("Please enter password");
                    etpassword.requestFocus();
                }else{
                    Intent intent=new Intent(Login_screen.this,Home_screen.class);
                    startActivity(intent);
                }

            }
        });


    }
}