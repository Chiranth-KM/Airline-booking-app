package com.example.skylineairbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class booked extends AppCompatActivity {

    TextView name;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked);

        name=findViewById(R.id.textView9);
        back=findViewById(R.id.button5);

        String n=getIntent().getStringExtra("key");
        String s=getIntent().getStringExtra("keys");
        name.setText("Passenger: "+n+""+s);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(booked.this,search.class);
                startActivity(intent);
                finish();
            }
        });
    }
}