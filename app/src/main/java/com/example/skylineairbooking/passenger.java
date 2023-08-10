package com.example.skylineairbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class passenger extends AppCompatActivity {

    EditText name, fullname,email,phone,id;
    CheckBox tc;
    Switch food, wheelchair;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger);

        name=findViewById(R.id.editTextText4);
        fullname=findViewById(R.id.editTextText2);
        email=findViewById(R.id.editTextTextEmailAddress);
        phone=findViewById(R.id.editTextPhone);
        id=findViewById(R.id.editTextNumber);
        tc=findViewById(R.id.checkBox);
        food=findViewById(R.id.switch2);
        wheelchair=findViewById(R.id.switch1);
        submit=findViewById(R.id.button);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(passenger.this)
                        .setMessage("Are you sure you want to book to ticket?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String a=name.getText().toString();
                                String b=fullname.getText().toString();
                                String c=email.getText().toString();
                                String d=phone.getText().toString();
                                String e=id.getText().toString();

                                if(a.equals("")||b.equals("")||c.equals("")||d.equals("")||e.equals(""))
                                {
                                    Toast.makeText(passenger.this, "Required feild", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    if(!tc.isChecked())

                                        Toast.makeText(passenger.this, "Accept Terms and conditions", Toast.LENGTH_SHORT).show();
                                    else
                                    {

                                        Intent intent=new Intent(passenger.this, booked.class);
                                        intent.putExtra("key",a);
                                        intent.putExtra("keys",b);
                                        finish();
                                        startActivity(intent);
                                    }
                                }
                            }
                        })
                        .setNegativeButton("No",null)
                        .show();
            }
        });
    }
}