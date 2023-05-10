package com.example.email;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button b;
    EditText e1,e2,e3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        b = (Button) findViewById( R.id.button );
        e1 = (EditText) findViewById( R.id.editTextTextPersonName );
        e2 = (EditText) findViewById( R.id.editTextTextPersonName2 );
        e3 = (EditText) findViewById( R.id.editTextTextPersonName3 );
        b.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to = e3.getText().toString();
                String subject = e2.getText().toString();
                String message = e1.getText().toString();

                Intent i = new Intent( Intent.ACTION_SEND );
                i.putExtra( Intent.EXTRA_EMAIL, new String[]{to} );
                i.putExtra( Intent.EXTRA_SUBJECT, subject );
                i.putExtra( Intent.EXTRA_TEXT, message );

                i.setType( "message/rfc822" );
                startActivity( Intent.createChooser( i, "Choose EMail App" ) );
            }
        } );
    }
}
