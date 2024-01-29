package com.sbit.task;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> list=new ArrayList<>();

    LayoutInflater layoutInflater;
    public CustomAdapter(Context applicationContext, ArrayList<String> alpabetlist) {
        this.context=applicationContext;
        this.list=alpabetlist;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.activity_row_grid, null);
        TextView textView = view.findViewById(R.id.titlegrid); // get the reference of ImageView
        if(list.size()>0){
            textView.setText(""+list.get(i));
        }else{
            Log.e("Size of list:", String.valueOf(list.size()));
        }
        return view;
    }
}
