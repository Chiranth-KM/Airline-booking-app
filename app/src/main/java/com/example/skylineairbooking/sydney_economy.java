package com.example.skylineairbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class sydney_economy extends AppCompatActivity {
    Button business, back,Quantas,newzealand,thai;
    private TextView date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sydney);

        business=findViewById(R.id.button2);
        back= findViewById(R.id.button3);
        Quantas= findViewById(R.id.button7);
        thai= findViewById(R.id.button8);
        newzealand= findViewById(R.id.button9);
        //date=findViewById(R.id.textView2);

        business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(sydney_economy.this,sydney_business.class);
                startActivity(intent);
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(sydney_economy.this,search.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void traveller(View view)
    {
        Intent intent=new Intent(sydney_economy.this, passenger.class);
        startActivity(intent);
        finish();
    }

}