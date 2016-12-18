package com.example.j2nn.se_term_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    DBHelper dbHelper = new DBHelper(getApplicationContext(), "MEMBER.db", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    public void submit(View view) {
        String id = ((EditText) findViewById(R.id.id)).getText().toString();
        String password = ((EditText) findViewById(R.id.password)).getText().toString();

        if (dbHelper.id(id).equals(id)) {
            if (dbHelper.password(id).equals(password)) {
                Toast.makeText(getApplicationContext(), "로그인 되었습니다", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "패스워드가 다릅니다", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "존재하지 않는 아이디입니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
