package com.example.gorcories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class Signupactivity extends AppCompatActivity {
    Button signup;
    TextView signinhere;
    EditText emailid,password;
    nodelogin loginapi;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    /**
     *
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactivity);
        signup = findViewById(R.id.button2);
        signinhere = findViewById(R.id.textView);
        emailid = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        Retrofit retrofit = RetrofitClient.getApiClient();
        loginapi = retrofit.create(nodelogin.class);
        signup.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param v
             */
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Signupactivity.this,HomeActivity.class);
//                startActivity(intent);
                register(emailid.getText().toString(),password.getText().toString());
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

    /**
     *
     * @param emailidpass
     * @param passwordpass
     * calls register api with nodejs and creates a new login when a new email id entered
     */
    private void register(String emailidpass, String passwordpass) {

        Log.v("dilip","inouts"+emailidpass+passwordpass);
        compositeDisposable.add(loginapi.registerUser(emailidpass,passwordpass)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.v("api text","dilip"+s);
                        if (s.contains("Register Success")){
                            Intent intent = new Intent(Signupactivity.this,HomeActivity.class);
                            startActivity(intent);}
                        else
                            Toast.makeText(Signupactivity.this,"User Already exists",Toast.LENGTH_LONG).show();
                    }
                }));
    }
}