package com.example.regional_language;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        ActionBar ac = getSupportActionBar();
        ac.setTitle(getResources().getString(R.string.app_name));
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChangeLanguage();

            }
        });

    }

    private void showChangeLanguage() {
        final String[] listItems={"Tamil","Hindi","Telugu"};
        AlertDialog.Builder m = new
                AlertDialog.Builder(MainActivity.this);
        m.setTitle("Choose Language");
        m.setSingleChoiceItems(listItems, -1,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(i==0){
                            setLocale("ta");
                            recreate();
                        }
                        else if(i==1){
                            setLocale("hi");
                            recreate();
                        }
                        else if(i==2){
                            setLocale("te");
                            recreate();
                        }
                        dialogInterface.dismiss();

                    }
                });
        AlertDialog mDialog = m.create();
        mDialog.show();
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration c = new Configuration();
        c.locale = locale;
        getBaseContext().getResources().updateConfiguration(c,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor e = getSharedPreferences("settings",MODE_PRIVATE).edit();
        e.putString("Mylang",lang);
        e.apply();

    }
    public void loadLocale(){
        SharedPreferences pre = getSharedPreferences("settings", Activity.MODE_PRIVATE);
        String lang = pre.getString("Mylang","");
        setLocale(lang);

    }
}
