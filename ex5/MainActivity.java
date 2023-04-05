package com.example.ex5;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2;
    Button b1, b2,b3,b4,b5;
    SQLiteDatabase db;
    String n, p;
    Cursor c,data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText)findViewById(R.id.editTextTextPersonName);
        e2 = (EditText)findViewById(R.id.editTextTextPersonName2);
        b1 = (Button)findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        b5=(Button)findViewById(R.id.button5);
        db = openOrCreateDatabase("Student", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS nametb ( name VARCHAR, place VARCHAR)");
        c=db.rawQuery("SELECT * FROM nametb;",null);
        data = db.rawQuery("SELECT * FROM nametb;",null);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL("INSERT INTO nametb VALUES ('" + e1.getText().toString() + "','" + e2.getText().toString() + "')");
                Toast.makeText(MainActivity.this, "Insert Success", Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c.moveToFirst();
                n=c.getString(0);
                p=c.getString(1);
                Intent i= new Intent(getApplicationContext(),MainActivity2.class);
                Bundle bun=new Bundle();
                bun.putString("na",n);
                bun.putString("pl",p);
                i.putExtras(bun);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c.moveToNext();
                n=c.getString(0);
                p=c.getString(1);
                Intent i= new Intent(getApplicationContext(),MainActivity2.class);
                Bundle bun=new Bundle();
                bun.putString("na",n);
                bun.putString("pl",p);
                i.putExtras(bun);
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.getCount() == 0) {
                    showDialogWithDbData("Error", "No data found");
                } else {
                    // String appending
                    StringBuilder stringBuilder = new StringBuilder();
                    while (data.moveToNext()) {
                        stringBuilder.append("Name: ").append(data.getString(0)).append("\n");
                        stringBuilder.append("Place: ").append(data.getString(1)).append("\n");
                    }
                    // Show all data in Alert Dialog
                    showDialogWithDbData("Data", stringBuilder.toString());
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL("DELETE FROM nametb WHERE place='" + e2.getText()+"';");
                Toast.makeText(MainActivity.this, "DELETE Success", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void showDialogWithDbData(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}