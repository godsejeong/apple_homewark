package com.wark.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

/**
 * Created by pc on 2017-06-08.
 */

public class memo extends AppCompatActivity {
    Toolbar toobar;
    EditText title;
    EditText value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memo);
        toobar = (Toolbar) findViewById(R.id.memo_tool);
        setSupportActionBar(toobar);
        title = (EditText) findViewById(R.id.title);
        value = (EditText) findViewById(R.id.value);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.memo_back, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.memo_back:
                getIntent().putExtra("title",title.getText().toString());
                getIntent().putExtra("value",value.getText().toString());
                setResult(RESULT_OK,getIntent());
                finish();
                break;
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}