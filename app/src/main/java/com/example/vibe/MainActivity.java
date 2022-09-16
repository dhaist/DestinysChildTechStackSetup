package com.example.vibe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.os.*;
import java.util.*;

import com.google.android.gms.tasks.*;
import com.google.firebase.database.*;
import com.google.firebase.firestore.*;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button transition;
    TextView text;
    EditText input;
    public static final String TAG = "MESSAGE";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference userRef = db.collection("users");
    //private DocumentReference docRef = FirebaseFirestore.getInstance().document("sampleData");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Write a message to the database


        input = (EditText)findViewById(R.id.inputText);
        text = findViewById(R.id.text_view);
        text.setText("Enter Your Name");
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String in = input.getText().toString();
                User user = new User(in);
                userRef.add(user);
            }
        });



        transition = (Button)findViewById(R.id.transition);
        transition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
