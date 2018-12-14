package com.example.android.todolist;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String  TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> task = new ArrayList<>();

        task.add(" Call Dad");
        task.add("Go to Gym");
        task.add("Drink Milk");
/**
        // giving id to the LinearLayout and finding the LinearLayout so that we add TextViews to that LinearLayout
       LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);

       for(int i = 0; i < task.size(); i++) {
           // now lets create a TextView object and add it to the LinearLayout

           TextView textView = new TextView(this);

           // now we have the TextView object textview, go ahead and add it to the LinearLayout to display the TextVies on the screen

           textView.setText(task.get(i));

           rootView.addView(textView);

           }**/

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, task );

        ListView listView = (ListView) findViewById(R.id.list_view_id);

        listView.setAdapter(itemsAdapter);
        }
    }

