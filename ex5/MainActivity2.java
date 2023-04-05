package com.example.ex5;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ex5.R;

public class MainActivity2 extends AppCompatActivity {
    TextView t1,t2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1=(TextView)findViewById(R.id.textView);
        t2=(TextView)findViewById(R.id.textView2);
        Bundle b =getIntent().getExtras();
        t1.setText(b.getString("na"));
        t2.setText(b.getString("pl"));
    }
}