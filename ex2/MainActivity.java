package com.example.ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e;
    EditText e2;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button) findViewById(R.id.button);
        e = (EditText) findViewById(R.id.editTextTextPersonName3);
        e2 = (EditText) findViewById(R.id.editTextTextPassword);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e.setTextSize(40);
                Intent i=new Intent(MainActivity.this,MainActivity2.class);
                Bundle b1=new Bundle();
                b1.putString("username",e.getText().toString());
                b1.putString("password",e2.getText().toString());
                i.putExtras(b1);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Successfully logined",Toast.LENGTH_SHORT).show();
            }
        });


    }
}