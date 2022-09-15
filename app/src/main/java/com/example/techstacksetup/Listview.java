package com.example.techstacksetup;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Listview extends AppCompatActivity {
    Button nameButton;
    EditText helloNameInput;
    TextView helloName;
    ListView show;
    ArrayList<String> addArray = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameButton = (Button)findViewById(R.id.button);
        helloNameInput  = (EditText)findViewById(R.id.editTextTextPersonName);
        helloName = (TextView)findViewById(R.id.helloName);
        //show = (ListView)findViewById(R.id.viewPoint);

        nameButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        helloName.setText("Hello, " + helloNameInput.getText());
                        String name = helloNameInput.getText().toString();
                        if(addArray.contains(name)){
                            Toast.makeText(getBaseContext(), "Name already in", Toast.LENGTH_SHORT).show();
                        }
                        else if (name == null || name.equals("")){
                            Toast.makeText(getBaseContext(), "Input empty", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            addArray.add(name);
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(Listview.this, android.R.layout.simple_list_item_1, addArray);
                            show.setAdapter(adapter);
                            ((EditText)findViewById(R.id.editTextTextPersonName)).setText(" ");
                        }
                    }


                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.list_view, menu);
        return true;
    }

}
