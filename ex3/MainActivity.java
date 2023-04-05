package com.example.ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Button b;
    ImageView i;
    Spinner s;
    String st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.button2);
        i=(ImageView) findViewById(R.id.imageView2);
        s=(Spinner)findViewById(R.id.spinner3);
        Bitmap bg=Bitmap.createBitmap( 720,1280, Bitmap.Config.ARGB_8888);
        i.setBackgroundDrawable(new BitmapDrawable(bg));
        Canvas c=new Canvas(bg);
        Paint p = new Paint();
        p.setTextSize(30);
        p.setColor(Color.BLACK);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st=s.getSelectedItem().toString();
                if(st.equals("Circle"))
                {
                    c.drawText("Circle",180,160,p);
                    c.drawCircle(200,350,150,p);
                }
                else if(st.equals("Square"))
                {
                    c.drawText("Square",180,160,p);
                    c.drawRect(100,200,400,600,p);
                }
                else
                {
                    c.drawText("Line",180,160,p);
                    c.drawLine(100,200,150,250,p);
                }

            }
        });
    }
}