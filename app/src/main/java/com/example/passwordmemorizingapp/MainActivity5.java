package com.example.passwordmemorizingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {

//    fields
    EditText userIdEdit, passwordEdit, domainEdit;
    Button updateButton, deleteButton;
    ImageButton clipboardBtn1, clipboardBtn2;

    Database2 db2;

    String UserId, Password, Domain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

//        reference
        userIdEdit = findViewById(R.id.userNameId5);
        passwordEdit = findViewById(R.id.passwordId5);
        domainEdit = findViewById(R.id.domainId5);
        updateButton = findViewById(R.id.updateButtonId);
        deleteButton = findViewById(R.id.cancelButtonId5);

        clipboardBtn1 = findViewById(R.id.copyUserId);
        clipboardBtn2 = findViewById(R.id.copyPasswordId);



//        initialising a database class
        db2 = new Database2(MainActivity5.this);

        getAndSetIntentData();


        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db2.updateData(Domain, userIdEdit.getText().toString(),
                                      passwordEdit.getText().toString(),
                                      domainEdit.getText().toString());
                db2.close();

                Intent in = new Intent(MainActivity5.this, MainActivity3.class);
                startActivity(in);

            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db2.deleteData(Domain);
                db2.close();

                Intent in = new Intent(MainActivity5.this, MainActivity3.class);
                startActivity(in);
            }
        });

//        clipboard activity
        clipboardBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("EditText",userIdEdit.getText().toString());
                clipboard.setPrimaryClip(clip);
                clip.getDescription();
                Toast.makeText(MainActivity5.this, "username copied", Toast.LENGTH_SHORT).show();
            }
        });

        clipboardBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("EditText",passwordEdit.getText().toString());
                clipboard.setPrimaryClip(clip);
                clip.getDescription();
                Toast.makeText(MainActivity5.this, "password copied", Toast.LENGTH_SHORT).show();
            }
        });





    }

    public void getAndSetIntentData() {

        if(getIntent().hasExtra("myId") && getIntent().hasExtra("myUserId") &&
                getIntent().hasExtra("myPassword") && getIntent().hasExtra("myDomain")) {

//            getting data from intent
            UserId = getIntent().getStringExtra("myUserId");
            Password = getIntent().getStringExtra("myPassword");
            Domain = getIntent().getStringExtra("myDomain");

//            setting intent data
            userIdEdit.setText(UserId);
            passwordEdit.setText(Password);
            domainEdit.setText(Domain);
        }
        else {
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        }
    }

}