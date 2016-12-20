package com.example.j2nn.se_term_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by kaira on 2016-12-20.
 */

public class MovieModify extends Activity {
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_modify);

        dbHelper = new DBHelper(getApplicationContext(), "MEMBER.db", null, 1);

        Intent intent = getIntent();
        String name = intent.getStringExtra("movieName").toString();

        ArrayList<String> arrayList = dbHelper.detail(name);

        EditText title = (EditText) findViewById(R.id.title);
        title.setText(arrayList.get(0));

        EditText grade = (EditText) findViewById(R.id.grade);
        grade.setText(arrayList.get(1));

        EditText director = (EditText) findViewById(R.id.director);
        director.setText(arrayList.get(2));

        EditText actors = (EditText) findViewById(R.id.actors);
        actors.setText(arrayList.get(3));

        EditText runningTime = (EditText) findViewById(R.id.runningTime);
        runningTime.setText(arrayList.get(4));

        EditText desc = (EditText) findViewById(R.id.desc);
        desc.setText(arrayList.get(6));

        EditText poster = (EditText) findViewById(R.id.poster);
        poster.setText(arrayList.get(5));
    }
    public void submit(View view) {
        String title = ((EditText) findViewById(R.id.title)).getText().toString();
        String grade = ((EditText) findViewById(R.id.grade)).getText().toString();
        String director = ((EditText) findViewById(R.id.director)).getText().toString();
        String actors = ((EditText) findViewById(R.id.actors)).getText().toString();
        String runningTime = ((EditText) findViewById(R.id.runningTime)).getText().toString();
        String desc = ((EditText) findViewById(R.id.desc)).getText().toString();
        String poster = ((EditText) findViewById(R.id.poster)).getText().toString();

        dbHelper.update(title, grade, director, actors, Integer.parseInt(runningTime), desc, poster);
        finish();
    }
}
