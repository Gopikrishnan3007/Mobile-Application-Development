manifest

<uses-permission android:name="android.permission.RECORD_AUDIO"></uses-permission>

Main Activity.java

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.File;
import java.io.IOException;
public class MainActivity extends AppCompatActivity {
    private static final int MICROPHONE_PERMISSION_CODE = 200;
    // private static final int RECORD_AUDIO = 0;
    Button rec, stop, play;
    MediaRecorder mr;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rec = (Button) findViewById(R.id.button);
        if(isMicrophonePresent())
        {
            getMicrophonePermission();
        }
        rec.setOnClickListener(new View.OnClickListener() {
            @Override
            //to record an audio...
            public void onClick(View view) {
                try
                {
                    mr = new MediaRecorder();
                    mr.setAudioSource(MediaRecorder.AudioSource.MIC);
                    mr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                    mr.setOutputFile(getRecordingFilePath());
                    mr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                    mr.prepare();
                    mr.start();
                    Toast toast;
                    Toast.makeText(MainActivity.this, "Recording is started",Toast.LENGTH_LONG).show();;
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });
        stop = (Button) findViewById(R.id.button2);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mr.stop();
                mr.release();
                mr = null;
                Toast.makeText(MainActivity.this, "Recording is Paused",Toast.LENGTH_LONG).show();
            }
        });
        play = (Button) findViewById(R.id.button3);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    mp = new MediaPlayer();
                    mp.setDataSource(getRecordingFilePath());
                    mp.prepare();
                    mp.start();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
    //to check whether microphone is available in your system or not.
    private boolean isMicrophonePresent()
    {

        if(this.getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //to get access to the microphone
    private void getMicrophonePermission()
    {
        if(ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.RECORD_AUDIO)==PackageManager.PERMISSION_DENIED)
        {
            ActivityCompat.requestPermissions(this,new
                    String[]{Manifest.permission.RECORD_AUDIO},MICROPHONE_PERMISSION_CODE);
        }
    }
    private String getRecordingFilePath()
    {
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        File dr = cw.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        File f = new File(dr, "recording1"+".mp3");
        return f.getPath();
    }
}
