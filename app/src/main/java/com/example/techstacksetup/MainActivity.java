package com.example.techstacksetup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    //Creates a firebase instance
    private FirebaseFirestore vDB = FirebaseFirestore.getInstance();
    //CollectionReference creates a reference to the collection we want to access
    private CollectionReference userRef = vDB.collection("names");


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
        final long[] mLastClickTime = {0};


        nameButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        if (SystemClock.elapsedRealtime() - mLastClickTime[0] < 10000){
                            helloName.setText("Button cool down. Please do not spam the save button.");
                            return;
                        }
                        mLastClickTime[0] = SystemClock.elapsedRealtime();
                        String name = helloNameInput.getText().toString();
                        User newUser = new User(name);
                        helloName.setText("Hello, " + name);
                        //sends data to the database
                        vDB.collection("names").add(newUser);

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