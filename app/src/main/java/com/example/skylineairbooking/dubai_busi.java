package com.example.skylineairbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dubai_busi extends AppCompatActivity {
    Button eco, back,qutar,vitara,airasia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dubai_busi);

        back = findViewById(R.id.button3);
        eco = findViewById(R.id.button);
        qutar=findViewById(R.id.button7);
        airasia=findViewById(R.id.button8);
        vitara=findViewById(R.id.button9);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dubai_busi.this, dubai.class);
                startActivity(intent);
                finish();
            }
        });
        eco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dubai_busi.this, dubai.class);
                startActivity(intent);
                finish();            }
        });
    }
    public void traveller(View view)
    {
        Intent intent=new Intent(this, passenger.class);
        startActivity(intent);
    }
}