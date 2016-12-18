package com.example.j2nn.se_term_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(getApplicationContext(), "MEMBER.db", null, 1);
    }

    public void signup(View view) {
        startActivity(new Intent(getApplicationContext(), Join.class));
    }
    public void login(View view) {
        startActivity(new Intent(getApplicationContext(), Login.class));
    }
}
