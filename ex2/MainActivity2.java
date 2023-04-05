package com.example.ex2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView e3,e4;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        e3 = (TextView) findViewById(R.id.textView);
        e4 = (TextView) findViewById(R.id.textView2);
        Bundle bun = getIntent().getExtras();
        e3.setText(bun.getCharSequence("username"));
        e4.setText(bun.getCharSequence("password"));
    }
}