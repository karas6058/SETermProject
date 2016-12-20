package com.example.j2nn.se_term_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Join extends AppCompatActivity {
    DBHelper dbHelper;
    public static boolean login = false;
    public static String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);
        dbHelper = new DBHelper(getApplicationContext(), "MEMBER.db", null, 1);
    }

    public void submit(View view) {
        id = ((EditText) findViewById(R.id.id)).getText().toString();
        String password1 = ((EditText) findViewById(R.id.password1)).getText().toString();
        String password2 = ((EditText) findViewById(R.id.password2)).getText().toString();

        if (id.equals(""))
        {
            Toast.makeText(getApplicationContext(), "아이디는 필수값입니다", Toast.LENGTH_SHORT).show();
            return;
        }
        if (dbHelper.id(id) == null)
        {
            if (password1.equals(password2))
            {
                if (password1.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "패스워드는 필수값입니다", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password1.length() < 6) {
                    Toast.makeText(getApplicationContext(), "패스워드는 6자 이상이어야 합니다", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHelper.insert(id, password1);
                Toast.makeText(getApplicationContext(), "가입되었습니다", Toast.LENGTH_SHORT).show();
                login = true;
                finish();
            } else
            {
                Toast.makeText(getApplicationContext(), "패스워드가 서로 다릅니다", Toast.LENGTH_SHORT).show();
            }
        } else
        {
            Toast.makeText(getApplicationContext(), "아이디가 이미 존재합니다", Toast.LENGTH_SHORT).show();
        }
    }
}
