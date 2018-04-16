package com.android.root.mayorexpress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomCardAdapter extends BaseAdapter {

    Context c;
    ArrayList<CustomCard> customcard;

    public CustomCardAdapter(Context c, ArrayList<CustomCard> customcard) {
        this.c = c;
        this.customcard = customcard;
    }

    @Override
    public int getCount() {
        return customcard.size();
    }

    @Override
    public Object getItem(int position) {
        return customcard.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.card_single,parent,false);
        }

        final CustomCard cd= (CustomCard) this.getItem(position);

        ImageView img= (ImageView) convertView.findViewById(R.id.image_card);
        TextView wt= (TextView) convertView.findViewById(R.id.work);
        TextView d1t= (TextView) convertView.findViewById(R.id.description1);
        TextView d2t= (TextView) convertView.findViewById(R.id.description2);

        //BIND
        wt.setText(cd.getW());
        d1t.setText(cd.getD1());
        d2t.setText(cd.getD2());
        img.setImageResource(cd.getImage());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, /*cd.getW()*/ "Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
