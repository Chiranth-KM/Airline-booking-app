package com.example.skylineairbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class search extends AppCompatActivity {
    Spinner destination;
    Button search,date;
    EditText text;
    TextView txt;

    private long backpresstime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        search=findViewById(R.id.button4);
        date=findViewById(R.id.button2);
        text=findViewById(R.id.dateformatID);


        destination=findViewById(R.id.editTextText2);
        String[] dest=getResources().getStringArray(R.array.destiantions);
        ArrayAdapter adapter=new ArrayAdapter(this, R.layout.my_selected,dest);
        adapter.setDropDownViewResource(R.layout.drop_down);
        destination.setAdapter(adapter);

        String val=text.getText().toString();
        destination.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String data=adapterView.getItemAtPosition(i).toString();

                if(data.equals("Sydney - SYD"))
                {
                    search.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i=new Intent(search.this, sydney_economy.class);
                            i.putExtra("keydate",val);
                            startActivity(i);
                        }
                    });
                } else if (data.equals("Dubai - DXB")) {
                    search.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent j=new Intent(search.this, dubai.class);
                            startActivity(j);
                        }
                    });
                } else if (data.equals("Select")) {
                    search.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(search.this, "Select a Destination", Toast.LENGTH_SHORT).show();
                        }
                    });

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog=new DatePickerDialog(search.this, new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker datePicker, int yy, int mm, int dd) {
                        text.setText(String.valueOf(dd)+" / "+String.valueOf(mm+1)+" / "+String.valueOf(yy));
                    }
                },2023,0,1);
                dialog.show();

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