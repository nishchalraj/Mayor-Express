package com.android.root.mayorexpress;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signUp extends AppCompatActivity {

    Button s;//signup button
    EditText n;//name
    EditText m;//mobile number
    EditText e;//email

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        s = (Button)findViewById(R.id.button_signup);
        n = (EditText)findViewById(R.id.edit_name);
        m = (EditText)findViewById(R.id.edit_number);
        e = (EditText)findViewById(R.id.edit_email);

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(signUp.this,navigation.class);
                startActivity(i);
                finish();
            }
        });
    }
}
