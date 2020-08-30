package com.example.gorcories;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * This class Splashscreen  Extends AppCompactActivity Which allow to load the activity where in it contains images, logo of the app.
 */

public class SplashScreen extends AppCompatActivity {
    /**
     * @param ImageView  used to show the logo inthe activity.
     */
    ImageView imageView;
    @Override

    /**
     *This method takes the xml elements ,process them and returns the view
     @param inflater instantiates a layout xml into its corresponding view objects
     @param container is a special view that contains other views
     @Param savedInstanceState it is used to pass data between the activities
     @Param animation used to load animation like fading in for a particular time.
     @return returns the specified ImageView on the inflater
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        imageView = findViewById(R.id.imageView2);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        imageView.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            /**
             * This method allows to open the splashcreen activity runs for particular amount of time.
             */
            public void run() {
                Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },1005);
    }
}
