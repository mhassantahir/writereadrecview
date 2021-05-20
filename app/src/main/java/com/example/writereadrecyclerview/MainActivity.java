package com.example.writereadrecyclerview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private static  final String TAG= "mytag";

    EditText username,email,password;
    Button login,detail;

    FirebaseDatabase database;
    DatabaseReference myRef;

    private ChildEventListener MyChildEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //edittext refferneces
        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);

        //button refferences
        login=findViewById(R.id.login);
        detail=findViewById(R.id.detail);

        //database refferences
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Users");

        MyChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                person myperson=snapshot.getValue(person.class);
                Log.d(TAG,"User_name :" + myperson.getUsername());
                Log.d(TAG,"User_password :" + myperson.getPassword());
                Log.d(TAG,"User_email :" + myperson.getEmail());
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        myRef.addChildEventListener(MyChildEventListener);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username=username.getText().toString();
                String Password=password.getText().toString();
                String Email=email.getText().toString();

                person myperson=new person(Username,Password,Email);

                //Auto key generator
                String key=myRef.push().getKey();
                myRef.child(key).setValue(myperson);

            }
        });
        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,detailview.class));
            }
        });

    }
}