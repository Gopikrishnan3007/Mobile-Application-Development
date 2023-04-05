package com.example.ex4anim;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button b;
    ImageView i;
    MediaPlayer m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.button);
        i=(ImageView) findViewById(R.id.imageView);
        m = MediaPlayer.create(MainActivity.this,R.raw.m1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        i.post(new Runnable() {
                            @Override
                            public void run() {
                                AnimationDrawable a=new AnimationDrawable();
                                a.addFrame(getResources().getDrawable(R.drawable.i1),500);
                                a.addFrame(getResources().getDrawable(R.drawable.i2),500);
                                a.setOneShot(false);
                                i.setBackgroundDrawable(a);
                                a.start();
                            }
                        });
                    }
                }).start();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        i.post(new Runnable() {
                            @Override
                            public void run() {
                                m.start();
                            }
                        });
                    }
                }).start();
            }
        });
    }
}