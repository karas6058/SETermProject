package com.example.j2nn.se_term_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by J2NN on 2016-12-17.
 */

public class Join extends AppCompatActivity {

    DBHelper dbHelper = new DBHelper(getApplicationContext(), "MEMBER.db", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);

        final EditText mid = (EditText) findViewById(R.id.id);
        final EditText mpw = (EditText) findViewById(R.id.password);

        Button join = (Button) findViewById(R.id.submit);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = mid.getText().toString();
                String pw = mpw.getText().toString();
                dbHelper.insert(id,pw);
            }
        });
    }
}
