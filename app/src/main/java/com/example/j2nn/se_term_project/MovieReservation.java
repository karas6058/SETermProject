package com.example.j2nn.se_term_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MovieReservation extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_check);

        Spinner spinner_title = (Spinner) findViewById(R.id.reserve_title);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.movie,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_title.setAdapter(adapter);
    }
    public void check_cancel() {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
}