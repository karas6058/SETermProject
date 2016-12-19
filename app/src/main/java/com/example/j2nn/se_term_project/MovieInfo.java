package com.example.j2nn.se_term_project;

import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by J2NN on 2016-12-17.
 */

public class MovieInfo extends AppCompatActivity{

    ArrayList<String> mInfoArray;
    ListView list;
    ListAdapter infoAdapter;
    DBHelper dbHelper = new DBHelper(getApplicationContext(), "MOVIE.db", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_info);

        list = (ListView) findViewById(R.id.listView);
        mInfoArray = new ArrayList<String>();

        Cursor cursor = dbHelper.info();
        while(cursor.moveToNext()) {
            mInfoArray.add(cursor.getString(0));
        }
    }
}