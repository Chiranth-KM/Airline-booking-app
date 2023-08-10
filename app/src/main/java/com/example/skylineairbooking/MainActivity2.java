package com.example.skylineairbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    DatabaseHelper db;
    Button signup;
    EditText email, pass, confirmpass,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        db=new DatabaseHelper(this);
        //Intent intent=getIntent();
        signup=findViewById(R.id.button);
        email=findViewById(R.id.editTextTextEmailAddress);
        pass=findViewById(R.id.editTextPhone);
        confirmpass =findViewById(R.id.editTextTextPassword2);
        name =findViewById(R.id.editTextText);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a=email.getText().toString();
                String b=pass.getText().toString();
                String c= confirmpass.getText().toString();
                String d=name.getText().toString();
                if(a.equals("")||b.equals("")||c.equals("")||d.equals(""))
                    Toast.makeText(MainActivity2.this, "Space can't be left blank", Toast.LENGTH_SHORT).show();
                else {
                    Boolean k=db.insertData(a,b,d);
                    if(!k)
                    {
                        if(b.equals(c))
                        {
                            Toast.makeText(MainActivity2.this, "Sign up Successfull", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(view.getContext(),MainActivity.class);
                            startActivity(intent);
                        }

                        else {
                            Toast.makeText(MainActivity2.this, "Confirm password wont match with orginal one", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(MainActivity2.this, "Invalid Signup", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}