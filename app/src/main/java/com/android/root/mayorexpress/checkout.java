package com.android.root.mayorexpress;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class checkout extends AppCompatActivity implements View.OnClickListener {

    ImageView im; //image_icon
    TextView w1;//work
    TextView d1;//description1
    TextView d2;//description2

    //-------------------------------------------------

    TextView cd;//see date
    TextView ct;//see time
    Button d;//choose date
    Button t;//choose time

    //-------------------------------------------------

    private int mYear, mMonth, mDay, mHour, mMinute;

    //-------------------------------------------------

    EditText a1;//address 1
    EditText a2;//address 2
    EditText a3;//address 3

    //-------------------------------------------------

    Button b;//book button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        //defining custom toolbar
        Toolbar toolbar =(Toolbar) findViewById(R.id.checkout_toolbar);
        setSupportActionBar(toolbar);

        //setting title of toolbar as the icon number
        getSupportActionBar().setTitle("Checkout");

        im = (ImageView)findViewById(R.id.check_image_card);
        w1 = (TextView)findViewById(R.id.check_work);
        d1 = (TextView)findViewById(R.id.check_description1);
        d2 = (TextView)findViewById(R.id.check_description2);

        cd = (TextView)findViewById(R.id.check_date);
        ct = (TextView)findViewById(R.id.check_time);
        d = (Button)findViewById(R.id.ch_date);
        t = (Button)findViewById(R.id.ch_time);

        a1 = (EditText)findViewById(R.id.address1);
        a2 = (EditText)findViewById(R.id.address2);
        a3 = (EditText)findViewById(R.id.address3);

        b = (Button)findViewById(R.id.book_button);

        d.setOnClickListener((View.OnClickListener) this);
        t.setOnClickListener((View.OnClickListener) this);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(checkout.this,subCategory.class);
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new services()).commit()
                Toast.makeText(getApplicationContext(),"Booked",Toast.LENGTH_SHORT).show();
                startActivity(j);
                finish();
            }
        });

    }


    @Override
    public void onClick(View view) {

        if (view == d) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            cd.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }

        if (view == t) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            ct.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }
}
