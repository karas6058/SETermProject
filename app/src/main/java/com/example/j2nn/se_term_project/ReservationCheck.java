package com.example.j2nn.se_term_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by J2NN on 2016-12-17.
 */

public class ReservationCheck extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_check);
    }
    public void check_submit() {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
    public void reserve_cancel() {
        startActivity(new Intent(getApplicationContext(), ReservationCancel.class));
    }
}