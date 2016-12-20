package com.example.j2nn.se_term_project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
                AlertDialog.Builder builder = new AlertDialog.Builder(Member.this);

                final String str = (String) parent.getItemAtPosition(position);

                AlertDialog dialog = builder.setTitle("삭제확인")
                        .setMessage(str+"을 삭제하시겠습니까?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dbHelper.deleteId(str);
                                ArrayAdapter adapter = new ArrayAdapter(Member.this, android.R.layout.simple_list_item_1, dbHelper.idAll());
                                listView.setAdapter(adapter);
                            }
                }).create();
                dialog.show();
            }
        }) ;
    }
}
