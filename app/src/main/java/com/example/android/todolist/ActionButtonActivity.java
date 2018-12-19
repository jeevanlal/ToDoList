package com.example.android.todolist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;

public class ActionButtonActivity extends AppCompatActivity {
    ArrayAdapter<String> adapter;
    int noteId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_button);

        EditText editText = (EditText) findViewById(R.id.edit_text_id);

        Intent intent = getIntent();
        noteId = intent.getIntExtra("noteId", -1);
        if (noteId != -1) {

            editText.setText(MainActivity.task.get(noteId));
        } else {
            MainActivity.task.add("");
            MainActivity.adapter.notifyDataSetChanged();
            noteId = MainActivity.task.size() - 1;
        }
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.task.set(noteId, String.valueOf(s));
                MainActivity.adapter.notifyDataSetChanged();
                SharedPreferences sharedPreferences = getApplicationContext()
                        .getSharedPreferences("com.example.ekene.mynotes", Context.MODE_PRIVATE);
                HashSet<String> set = new HashSet<String>(MainActivity.task);
                sharedPreferences.edit().putStringSet("notes", set).apply();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }
}
