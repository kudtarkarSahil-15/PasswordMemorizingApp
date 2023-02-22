package com.example.passwordmemorizingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    //fields
    private EditText emailInputW, passwordInputW, confirmPasswordW;
    private Button buttonSignUp;
    Database1 wd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        /* References */
        emailInputW = findViewById(R.id.emailInputS);
        passwordInputW = findViewById(R.id.passwordInputS);
        confirmPasswordW = findViewById(R.id.confirmPasswordInputS);
        buttonSignUp = findViewById(R.id.buttonSignUp);

        /**/
        wd = new Database1(this);

        //put data into db
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //fetching user entered data
                String emailDataS = emailInputW.getText().toString();
                String passwordDataS = passwordInputW.getText().toString();
                String confirmPasswordDataS = confirmPasswordW.getText().toString();

                if(!(confirmPasswordDataS.equals(passwordDataS))) {
                    Toast.makeText(MainActivity2.this, "Confirm Password Match With Password", Toast.LENGTH_SHORT).show();
                    // c mark the position
                }
                else {
                    if(emailDataS.equals("") || passwordDataS.equals("") || confirmPasswordDataS.equals("")) {
                        Toast.makeText(MainActivity2.this, "complete all the fields", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        boolean insertVal = wd.signUp(emailDataS, confirmPasswordDataS);
                        if(insertVal == true) {
                            Toast.makeText(MainActivity2.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(MainActivity2.this, "Registered Unsuccessfully", Toast.LENGTH_SHORT).show();
                        }

                        Intent in = new Intent(MainActivity2.this,MainActivity.class);
                        startActivity(in);

                    }
                }


            }
        });

    }
}