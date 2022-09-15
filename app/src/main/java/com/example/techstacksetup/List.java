package com.example.techstacksetup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class List extends AppCompatActivity {
    ListView listName;
    Button returnToMainButton;
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

        // button that returns to main activity
        returnToMainButton = (Button)findViewById(R.id.returnToMain);
        returnToMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(List.this, MainActivity.class);
                startActivity(intent);
            }
        });
   }
}