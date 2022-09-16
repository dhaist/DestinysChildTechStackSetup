package com.example.vibe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.telephony.TelephonyCallback;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.content.*;
import android.os.Bundle;

import com.google.android.gms.tasks.*;
import com.google.firebase.database.*;
import com.google.firebase.firestore.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecondActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference usersRef = db.collection("users");
    private List<String> nameArray;
    Button returnHome;
    ListView listview;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        returnHome = (Button)findViewById(R.id.returnToMain);
        CollectionReference c = db.collection("users");
        nameArray = new ArrayList<>();
        textView = findViewById(R.id.textView3);

        returnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void loadName(View v){
        usersRef.get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        String data = "";
                        for(QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                            User user = documentSnapshot.toObject(User.class);
                            String name = user.getName();
                            data += "Name: " + name + "\n";
                            nameArray.add(data);
                        }
                        textView.setText(data);
                    }
                });
    }
}