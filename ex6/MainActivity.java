package com.example.ex6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.button);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.button3);
        e1=(EditText) findViewById(R.id.editTextTextPersonName);
        e1.setHint("Enter some lines of data here...");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message=e1.getText().toString();
                try
                {
                    File f=new File("/sdcard/ll.txt");
                    f.createNewFile();
                    FileOutputStream fout=new FileOutputStream(f);
                    fout.write(message.getBytes());
                    fout.close();
                    Toast.makeText(getApplicationContext(),"Data Written in SDCARD",Toast.LENGTH_LONG).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String m="";
                String b = "";
                try
                {
                    File f = new File("/sdcard/ll.txt");
                    FileInputStream fin = new FileInputStream(f);
                    BufferedReader br = new BufferedReader(new InputStreamReader(fin));
                    while ((m = br.readLine()) != null)
                    {
                        b += m;
                    }
                    e1.setText(b);
                    br.close();
                    fin.close();
                    Toast.makeText(getApplicationContext(),"Data Recived from SDCARD",Toast.LENGTH_LONG).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("");
            }
        });
    }
}