package com.example.j2nn.se_term_project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by J2NN on 2016-12-17.
 */

public class MovieInfo extends AppCompatActivity{

    ListView list;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_info);

        dbHelper = new DBHelper(getApplicationContext(), "MOVIE.db", null, 1);

        list = (ListView) findViewById(R.id.listView);

        list.invalidate();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dbHelper.info());
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                final String str = (String) parent.getItemAtPosition(position);

                Intent intent = new Intent(getApplicationContext(), MovieInfoDetailView.class);
                intent.putExtra("movieName", str);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dbHelper.info());
        list.setAdapter(adapter);

    }
}