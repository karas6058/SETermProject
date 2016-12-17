package com.example.j2nn.se_term_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by J2NN on 2016-12-17.
 */

public class Join extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);
    }

    public void submit(View view) {
        final EditText id = (EditText) findViewById(R.id.id);
        final EditText password1 = (EditText) findViewById(R.id.password1);
        final EditText password2 = (EditText) findViewById(R.id.password2);
        final Button button = (Button) findViewById(R.id.submit);

        if (true) {//TODO db에서 아이디 중복 확인
            if (password1.getText().toString().equals(password2.getText().toString())) {
                //TODO 아이디와 패스워드 DB에 등록
            } else {
                Toast.makeText(getApplicationContext(), "패스워드가 서로 다릅니다", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "아이디가 이미 존재합니다", Toast.LENGTH_SHORT).show();
        }
    }
}
