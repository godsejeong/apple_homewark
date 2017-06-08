package com.wark.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    EditText search;
    ListView List;
    String val;
    String title;
    ArrayAdapter<String> adatper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        search = (EditText) findViewById(R.id.main_search);
        List = (ListView) findViewById(R.id.list);

        adatper= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        toolbar.setTitle("main");
        List.setAdapter(adatper);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.memo :
                Toast.makeText(this, "menu item clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,memo.class);
                startActivityForResult(intent, 200);
                break;
        }
        return true;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 200:
                val = data.getStringExtra("value");
                title = data.getStringExtra("title");
                adatper.add(val+"\n"+title);
                Toast.makeText(getApplicationContext(),val+"\n"+title,Toast.LENGTH_SHORT).show();
        }
    }
}
