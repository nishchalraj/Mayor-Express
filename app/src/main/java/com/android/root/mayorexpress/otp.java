package com.android.root.mayorexpress;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

public class otp extends AppCompatActivity {

    android.widget.Button a; //button authenticate
    EditText otp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle b = getIntent().getExtras();
        String n = b.getString("number");
        setContentView(R.layout.activity_otp);

        a = (android.widget.Button)findViewById(R.id.sign_button);
        otp = (EditText)findViewById(R.id.edit_otp);

        if(n.equals("0"))
            a.setText("Sign Up");
        if(n.equals("1"))
            a.setText("Sign In");

        a.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                if(a.getText().toString().equals("Sign Up"))
                    {
                       Intent i = new Intent(otp.this, signUp.class);
                       startActivity(i);
                       finish();
                    }
                else if(a.getText().toString().equals("Sign In"))
                    {
                       Intent j = new Intent(otp.this, navigation.class);
                       startActivity(j);
                       finish();
                    }
                else Toast.makeText(getApplicationContext(),"Not Allowed",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
