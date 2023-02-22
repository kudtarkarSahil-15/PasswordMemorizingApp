package com.example.passwordmemorizingapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

//    fields
    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    Button logoutButton;

    Database2 db2;
    ArrayList<String> recordId, userId, password, domain;
    RecAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
// to remove a title and action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main3);


//        reference
        recyclerView = findViewById(R.id.recyclerViewId);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        logoutButton = findViewById(R.id.logoutButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity3.this, MainActivity4.class);
                startActivity(in);
            }
        });

        db2 = new Database2(MainActivity3.this);
        recordId = new ArrayList<>();
        userId = new ArrayList<>();
        password = new ArrayList<>();
        domain = new ArrayList<>();

        displayData();


        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity3.this));
        myAdapter = new RecAdapter(MainActivity3.this, recordId, userId, password, domain);
        recyclerView.setAdapter(myAdapter);


        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(in);
                Toast.makeText(MainActivity3.this, "Logout Successfully", Toast.LENGTH_SHORT).show();
            }
        });

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if(requestCode == 1) {
//            recreate();
//        }
//    }

    //storing a data in Arrays with this method
void displayData() {

    Cursor cursor = db2.scanData();
    if(cursor.getCount() == 0) {
        Toast.makeText(MainActivity3.this, "No Data Found...!!", Toast.LENGTH_SHORT).show();
    }
    else {
        while (cursor.moveToNext()) {
//                    reading column
            recordId.add(cursor.getString(0));
            userId.add(cursor.getString(1));
            password.add(cursor.getString(2));
            domain.add(cursor.getString(3));
        }
    }
}
}