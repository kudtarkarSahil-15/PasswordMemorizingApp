package com.example.passwordmemorizingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity4 extends AppCompatActivity {

//    fields
    EditText userIdN, passwordN, domainN;
    Button addDataN, cancelN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

//        reference
        userIdN = findViewById(R.id.userId4);
        passwordN = findViewById(R.id.passwordId4);
        domainN = findViewById(R.id.domainId4);
        addDataN = findViewById(R.id.addButtonId4);
        cancelN = findViewById(R.id.cancelButtonId4);


        addDataN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Database2 dbAdd = new Database2(MainActivity4.this);
                dbAdd.addRecords(userIdN.getText().toString().trim(),
                               passwordN.getText().toString().trim(),
                               domainN.getText().toString().trim());

                Intent in = new Intent(MainActivity4.this, MainActivity3.class);
                startActivity(in);
            }
        });

        cancelN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userIdN.setText("");
                passwordN.setText("");
                domainN.setText("");
            }
        });
    }
}