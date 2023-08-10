package com.example.skylineairbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dubai extends AppCompatActivity {
    Button business, back,qutar,vitara,airasia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dubai_economy);

        business=findViewById(R.id.button2);
        back= findViewById(R.id.button3);
        qutar=findViewById(R.id.button7);
        airasia=findViewById(R.id.button8);
        vitara=findViewById(R.id.button9);


        business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(dubai.this, dubai_busi.class);
                startActivity(intent);
                finish();

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(dubai.this,search.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void traveller(View view)
    {
        Intent intent=new Intent(this, passenger.class);
        startActivity(intent);
    }
}