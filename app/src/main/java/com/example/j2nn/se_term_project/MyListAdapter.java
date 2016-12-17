package com.example.j2nn.se_term_project;

/**
 * Created by J2NN on 2016-12-18.
 */

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter{

    private Context maincon;
    private LayoutInflater Inflater;
    private ArrayList<MyItem> arSrc;
    int layout;

    public MyListAdapter(Context context, int alayout, ArrayList<MyItem> aarSrc) {
        maincon = context;
        Inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        arSrc = aarSrc;
        layout = alayout;

    }

    @Override
    public int getCount() {
        return arSrc.size();
    }

    @Override
    public Object getItem(int position) {
        return arSrc.get(position).movieName;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = Inflater.inflate(layout, parent, false);
        }

        ImageView _poster = (ImageView) convertView.findViewById(R.id.poster);
        _poster.setImageResource(maincon.getResources().getIdentifier(arSrc.get(position).movieImg, "drawable", maincon.getPackageName()));

        return null;
    }
}
