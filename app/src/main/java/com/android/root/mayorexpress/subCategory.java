package com.android.root.mayorexpress;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.GridView;

import java.util.ArrayList;

public class subCategory extends AppCompatActivity {

    CustomCardAdapter customCardAdapter;
    GridView scg;//sub_cat_grid definition

    ArrayList<CustomCard> customcard = new ArrayList<>();
    int img;
    String w;
    String d1;
    String d2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        //taking item number clicked
//        Bundle a =getIntent().getExtras();
//        String b = a.getString("itemClicked");
        setContentView(R.layout.activity_sub_category);

        //defining shared preferences
        SharedPreferences mSettings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String titl = mSettings.getString("itemClicked","null");

        //defining custom toolbar
        Toolbar toolbar =(Toolbar) findViewById(R.id.sub_toolbar);
        setSupportActionBar(toolbar);

        //setting title of toolbar as the icon number
        getSupportActionBar().setTitle(titl.replace("\"",""));

        scg= (GridView) findViewById(R.id.sub_cat_grid);
        customCardAdapter = new CustomCardAdapter(this,customcard);

        for(int i=0;i<50;i++)
        {
            CustomCard cc=new CustomCard(img,w,d1,d2);

            cc.setW("Work " + i);
            cc.setD1("Description "+i+ " 1");
            cc.setD2("Description "+i+ " 2");
            cc.setImage(R.drawable.example);
            customcard.add(cc);
        }
        scg.setAdapter(customCardAdapter);
    }

}
