package com.example.skylineairbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText mail, passwd;
    Button signup,login;
    private long backpresstime;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mail = findViewById(R.id.textView5);
        passwd = findViewById(R.id.editTextTextPassword2);
        login = findViewById(R.id.button);
        signup = findViewById(R.id.button3);
        db=new DatabaseHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = mail.getText().toString();
                String y = passwd.getText().toString();

                if (x.equals("") || y.equals("")) {
                    Toast.makeText(MainActivity.this, "Space can't be left blank", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkerboards = db.checkEmailPassword(x, y);
                    if (checkerboards)
                    {

                        Toast.makeText(MainActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(MainActivity.this, search.class);
                        startActivity(intent);
                        finish();

                    }

                    else {
                        Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        
        if(backpresstime+2000>System.currentTimeMillis())
        {
            super.onBackPressed();
            return;
        }
        else {
            Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        backpresstime=System.currentTimeMillis();
    }
}