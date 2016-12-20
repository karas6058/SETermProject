package com.example.j2nn.se_term_project;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by kairas on 2016-12-20.
 */
public class Member extends AppCompatActivity {

    private ListView listView;
    DBHelper dbHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member);

        dbHelper = new DBHelper(getApplicationContext(), "MEMBER.db", null, 1);

        listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dbHelper.idAll());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                String str = (String) parent.getItemAtPosition(position);
                Toast.makeText(Member.this, str, Toast.LENGTH_SHORT).show();
                dbHelper.deleteId(str);
            }
        }) ;
    }
}
