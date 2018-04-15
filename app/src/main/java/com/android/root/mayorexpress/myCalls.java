package com.android.root.mayorexpress;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import static com.android.root.mayorexpress.R.id.call_listview;

public class myCalls extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my_calls,container,false);

        ListView ll = (ListView)view.findViewById(R.id.call_listview);
        String[] lst = new String[50];
        for(int i = 0;i<50 ;i++)
        {
            lst[i] = "Call #" + i;
        }

        //defining and Declaring an ArrayAdapter to set items to ListView
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, lst);
        ll.setAdapter(adapter);
    return view;
    }

}
