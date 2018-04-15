package com.android.root.mayorexpress;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    Button s; //submit button
    EditText n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        s = (Button)findViewById(R.id.submit_button);
        n = (EditText)findViewById(R.id.edit_number);

        s.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(n.getText().toString().matches(""))
                        Toast.makeText(getApplicationContext(),"Enter your mobile number first !",Toast.LENGTH_SHORT).show();
                    else
                    {
                        Intent i = new Intent(login.this, otp.class);
                        i.putExtra("number",n.getText().toString());
                        startActivity(i);
                        finish();

                    }

            }
        });

    }
}
