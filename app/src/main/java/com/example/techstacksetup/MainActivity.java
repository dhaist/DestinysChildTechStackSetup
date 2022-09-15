package com.example.techstacksetup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button nameButton,nextbtn;
    EditText helloNameInput;
    TextView helloName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameButton = (Button)findViewById(R.id.button);
        nextbtn = (Button)findViewById(R.id.nextBtn);
        helloNameInput  = (EditText)findViewById(R.id.editTextTextPersonName);
        helloName = (TextView)findViewById(R.id.helloName);

        nameButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        helloName.setText("Hello, " + helloNameInput.getText());
                    }
                });


        /**
         * onClick function to the next activity
         */
        nextbtn.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        Intent intent = new Intent(MainActivity.this, List.class);
                        startActivity(intent);
                    }
                }
        );
    }


}