package com.example.ex_9;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
 Button b;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 b=(Button)findViewById(R.id.button);
 b.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View view) {
 AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//Setting message manually and performing action on button click
 builder.setMessage("Do you want to close this application ?")
 .setCancelable(false)
 .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
 public void onClick(DialogInterface dialog, int id) {
 finish();
 }
 })
 .setNegativeButton("No", new DialogInterface.OnClickListener() {
 public void onClick(DialogInterface dialog, int id) {
 // Action for 'NO' Button
 dialog.cancel();
 }
 });
 //Creating dialog box
 AlertDialog alert = builder.create();
 //Setting the title manually
 alert.setTitle("Alertdemo");
 alert.show();
 }
 });
 }
}