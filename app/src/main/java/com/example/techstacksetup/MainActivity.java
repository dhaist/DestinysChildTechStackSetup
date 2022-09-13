package com.example.techstacksetup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button nameButton;
    EditText helloNameInput;
    TextView helloName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameButton = (Button)findViewById(R.id.button);
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
    }
}