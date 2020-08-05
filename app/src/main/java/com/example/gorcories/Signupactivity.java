package com.example.gorcories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Signupactivity extends AppCompatActivity {
    Button signup;
    TextView signinhere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactivity);
        signup = findViewById(R.id.button2);
        signinhere = findViewById(R.id.textView);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signupactivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        signinhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signupactivity.this,SigninActivity.class);
                startActivity(intent);
            }
        });
    }
}