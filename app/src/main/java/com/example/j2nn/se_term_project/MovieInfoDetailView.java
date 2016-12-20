package com.example.j2nn.se_term_project;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.j2nn.se_term_project.Join.id;

/**
 * Created by J2NN on 2016-12-17.
 */

public class MovieInfoDetailView extends Activity {

    DBHelper dbHelper;
    String name = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_info_detail);

        dbHelper = new DBHelper(getApplicationContext(), "MEMBER.db", null, 1);

        Intent intent = getIntent();
        name = intent.getStringExtra("movieName").toString();

        ArrayList<String> arrayList = dbHelper.detail(name);

        TextView title = (TextView) findViewById(R.id.title);
        title.setText(arrayList.get(0));

        TextView grade = (TextView) findViewById(R.id.grade);
        grade.setText(arrayList.get(1));

        TextView director = (TextView) findViewById(R.id.director);
        director.setText(arrayList.get(2));

        TextView actors = (TextView) findViewById(R.id.actors);
        actors.setText(arrayList.get(3));

        TextView runningTime = (TextView) findViewById(R.id.runningTime);
        runningTime.setText(arrayList.get(4)+"분");

        TextView desc = (TextView) findViewById(R.id.desc);
        desc.setText(arrayList.get(6));

        ImageView poster = (ImageView) findViewById(R.id.poster);
        poster.setImageResource(getResources().getIdentifier(arrayList.get(5), "drawable", getPackageName()));

        Button modify = (Button) findViewById(R.id.modify);
        Button delete = (Button) findViewById(R.id.delete);

        if (id != null && id.equals("admin")) {
            modify.setVisibility(View.VISIBLE);
            delete.setVisibility(View.VISIBLE);
        }
    }

    public void delete(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(MovieInfoDetailView.this);

        AlertDialog dialog = builder.setTitle("삭제확인")
                .setMessage(name+"을 삭제하시겠습니까?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dbHelper.deleteMovie(name);
                        finish();
                    }
                }).create();
        dialog.show();
    }

    public void modify(View view) {
        Intent intent = new Intent(getApplicationContext(), MovieModify.class);
        intent.putExtra("movieName", name);
        startActivity(intent);
        finish();
    }
}
