package com.example.skylineairbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class splashscreen extends AppCompatActivity {
    TextView appname;
    LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        appname=findViewById(R.id.textView8);
        lottie=findViewById(R.id.lottie);

        lottie.animate().translationX(2000).setDuration(2900).setStartDelay(3000);
        appname.animate().translationY(-1400).setDuration(1000).setStartDelay(0);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);
    }
}