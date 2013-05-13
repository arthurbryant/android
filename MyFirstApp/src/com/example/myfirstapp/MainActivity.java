package com.example.myfirstapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	private static String[] myStringArray = {"arthur", "bryant", "wendy"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.title);
        setContentView(R.layout.activity_main);
        
        Language language_data[] = new Language[] {
        		new Language(R.drawable.language_c, "C"),
        		new Language(R.drawable.language_java, "Java")
        };
        LanguageAdapter adapter = new LanguageAdapter(this, R.layout.listview_row, language_data);
        ListView listView = (ListView) findViewById(R.id.row_list);
        View header = (View)getLayoutInflater().inflate(R.layout.listview_header, null);
        listView.addHeaderView(header);
        listView.setAdapter(adapter);
        /*
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myStringArray);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.row, myStringArray);

        listView.setAdapter(adapter);
        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
