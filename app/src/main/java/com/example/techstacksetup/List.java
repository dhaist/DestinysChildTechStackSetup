package com.example.techstacksetup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class List extends AppCompatActivity {
    ListView listName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listName=(ListView)findViewById(R.id.listName);

        //array of names for testing
        String[] name = {"Moe","Kaid","Smith"};

        //adapter to connecet the string array
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, name);

        //setting the listView to the adapter
        listName.setAdapter(arrayAdapter);
   }
}