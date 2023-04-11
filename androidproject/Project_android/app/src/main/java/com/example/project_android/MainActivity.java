package com.example.project_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7;
    Button btn1,btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.stname);
        ed2 = findViewById(R.id.mark1);
        ed3 = findViewById(R.id.mark2);
        ed4 = findViewById(R.id.mark3);
        ed5 = findViewById(R.id.total);
        ed6 = findViewById(R.id.avg);
        ed7 = findViewById(R.id.grade);


        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stmarks();
            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clear();
            }
        });

    }


    public void stmarks()
    {

        int m1,m2,m3,tot;
        double avg;
        String name,grade ,gd;
        name = ed1.getText().toString();
        m1 = Integer.parseInt(ed2.getText().toString());
        m2 = Integer.parseInt(ed3.getText().toString());
        m3 = Integer.parseInt(ed4.getText().toString());

        tot = m1 + m2 + m3;
        String total = Integer.toString(tot);
        ed5.setText(String.valueOf(tot));
        avg = tot/3;
        String average=Integer.toString((int) avg);


        ed6.setText(String.valueOf(avg));

        if(avg > 75)
        {
          grade="A";
        }
        else if(avg > 65)
        {
            grade="B";
        }
        else if(avg > 55)
        {
            grade="C";
        }
        else if(avg > 40)
        {
            grade="S";
        }

        else {
            grade="Failed";
        }

        Intent intent = new Intent(MainActivity.this,MainActivity3.class);
        intent.putExtra("NAME",name);
        intent.putExtra("TOTAL",total);
        intent.putExtra("AVG",average);
        intent.putExtra("GRADE",grade);
        startActivity(intent);
    }

    public void clear()
    {
        ed1.setText("");
        ed2.setText("");
        ed3.setText("");
        ed4.setText("");
        ed5.setText("");
        ed6.setText("");
        ed7.setText("");

        ed1.requestFocus();

    }
}