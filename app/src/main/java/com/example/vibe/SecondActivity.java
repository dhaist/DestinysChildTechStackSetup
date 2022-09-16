package com.example.vibe;


import androidx.appcompat.app.AppCompatActivity;


import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.*;
import android.content.*;
import android.os.Bundle;

import com.google.android.gms.tasks.*;

import com.google.firebase.firestore.*;


public class SecondActivity extends AppCompatActivity {

    //Firebase instance. This connects to the database
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    //This line connects to a collection in the database called users
    private CollectionReference usersRef = db.collection("users");
    Button returnHome;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        returnHome = (Button)findViewById(R.id.returnToMain);
        textView = findViewById(R.id.textView3);
        textView.setMovementMethod(new ScrollingMovementMethod());

        //This code takes you to the home page when back button is clicked
        returnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    //This method loads the names from the database and displays them
    //This method is invoked when the user clicks on the fetch button
    public void loadName(View v){
        usersRef.get() //get method grabs all the information from the collection users
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    //onSuccess method makes sure get method works
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        String data = "";
                        //For loop which goes through every piece of data in the collection
                        for(QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                            //Creates a new user. Sends info User.class
                            User user = documentSnapshot.toObject(User.class);
                            //set a variable for the name of the user using getName from the user class
                            String name = user.getName();
                            //Data is a large string with a new line after every entry
                            data += "Name: " + name + "\n";
                        }
                        //Displays the data to the screen
                        textView.setText(data);
                    }
                });
    }
}