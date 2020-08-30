package com.example.gorcories;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * This MainActivity is used as Navigation Between Sign up screen and login screen.
 *
 */

public class MainActivity extends AppCompatActivity {


    /**
     * @param signin used for signin button.
     *  @param signup used for signup button.
     */
    Button signin,signup;

    /**
     *  @Param savedInstanceState it is used to pass data between the aactivities
     *  This method takes the xml elements ,process them and returns the view.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Helps to load the Signin view through intent and onClick of button.
         */
        signin = findViewById(R.id.signin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SigninActivity.class);
                startActivity(intent);
            }
        });
        /**
         * Helps to load the Signup view through intent and onClick of button.
         */
        signup = findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Signupactivity.class);
                startActivity(intent);
            }
        });
    }
}
