package com.android.root.mayorexpress;

import android.content.ClipData;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class services extends Fragment {

    ViewPager viewPager;

    GridView grid;
    int[] imageId = new int[50];
    CustomGrid adapter;

//    int[] imageId = {R.drawable.example, R.drawable.example,R.drawable.example,R.drawable.example,
//            R.drawable.example,R.drawable.example,
//            R.drawable.example,R.drawable.example,
//            R.drawable.example,          R.drawable.example,
//            R.drawable.example,           R.drawable.example,
//            R.drawable.example,           R.drawable.example,
//            R.drawable.example,           R.drawable.example,
//            R.drawable.example,           R.drawable.example,
//            R.drawable.example,           R.drawable.example,
//            R.drawable.example,          R.drawable.example,
//            R.drawable.example,          R.drawable.example,
//            R.drawable.example,          R.drawable.example,
//            R.drawable.example,          R.drawable.example,
//            R.drawable.example,          R.drawable.example,
//            R.drawable.example,          R.drawable.example,
//            R.drawable.example,          R.drawable.example,
//            R.drawable.example,          R.drawable.example,
//    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_services,container,false);

        //for image slider
        viewPager = (ViewPager)view.findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity());
        viewPager.setAdapter(viewPagerAdapter);

        //for icon grids
        CustomGrid adapter = new CustomGrid(getActivity(),imageId);
        grid = (GridView)view.findViewById(R.id.grid);
        for(int i=0;i<50;i++)
        {
            imageId[i] = R.drawable.example;

            //on clicking icons in the grid view
            grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(getActivity(), "You Clicked at " + imageId[+position], Toast.LENGTH_SHORT).show();
                }
            });
        }
        grid.setAdapter(adapter);

        return view;
    }

}
