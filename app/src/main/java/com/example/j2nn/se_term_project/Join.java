package com.example.j2nn.se_term_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Join extends AppCompatActivity {
    DBHelper dbHelper = new DBHelper(getApplicationContext(), "MEMBER.db", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);
    }

    public void submit(View view) {
        String id = ((EditText) findViewById(R.id.id)).getText().toString();
        String password1 = ((EditText) findViewById(R.id.password1)).getText().toString();
        String password2 = ((EditText) findViewById(R.id.password2)).getText().toString();

        if (dbHelper.select(id) == null) {
            if (password1.equals(password2)) {
                dbHelper.insert(id, password1);
            } else {
                Toast.makeText(getApplicationContext(), "패스워드가 서로 다릅니다", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "아이디가 이미 존재합니다", Toast.LENGTH_SHORT).show();
        }
    }
}
