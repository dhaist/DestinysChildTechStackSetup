package com.example.techstacksetup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class List extends AppCompatActivity {
    Button returnToMainButton;
    //Firebase instance. This connects to the database
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    //connects to a collection in the database called users
    private CollectionReference usersRef = db.collection("names");
    private ArrayList<String> nameArray;
    ListView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        CollectionReference c = db.collection("names");
        nameArray = new ArrayList<>();
        view = (ListView)findViewById(R.id.list);
        view.setBackgroundColor(Color.WHITE);


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
    //loads the names from the database and displays them
    //invoked when the user clicks on the fetch button
    public void loadName(View v){
        usersRef.get()//get method grabs all the information from the collection users
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
                            nameArray.add(name);
                        }
                        //Displays the data to the screen
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                                android.R.layout.simple_list_item_1, nameArray);

                        view.setAdapter(arrayAdapter);
                    }
                });
    }
}