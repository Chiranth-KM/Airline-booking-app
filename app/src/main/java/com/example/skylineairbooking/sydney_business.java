package com.example.skylineairbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sydney_business extends AppCompatActivity {
    Button eco,back,Quantas,newzealand,thai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sydney_business);

        back= findViewById(R.id.button3);
        eco=findViewById(R.id.button);
        Quantas= findViewById(R.id.button7);
        thai= findViewById(R.id.button8);
        newzealand= findViewById(R.id.button9);
    }
    public void backandeco(View view)
    {
        Intent intent=new Intent(this,sydney_economy.class);
        startActivity(intent);
        finish();
    }

    public void traveller(View view)
    {
        Intent intent=new Intent(this, passenger.class);
        startActivity(intent);
    }
}