package com.example.passwordmemorizingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //fields
    private TextView signUp, signTextIns ;
    private EditText emailInputR, passwordInputR;
    private Button buttonLogin;
    StartDatabase rd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* References */
        signUp = findViewById(R.id.signUpView);
        emailInputR = findViewById(R.id.emailInput);
        passwordInputR = findViewById(R.id.passwordInput);
        buttonLogin = findViewById(R.id.buttonLogin);

        /**/
        rd = new StartDatabase(this);

        /*go to signUpView*/
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(in);
            }
        });

        /*after sign up*/
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailDataL = emailInputR.getText().toString();
                String passwordDataL = passwordInputR.getText().toString();

                if(emailDataL.equals("") || passwordDataL.equals("")) {
                    Toast.makeText(MainActivity.this, "complete all fields", Toast.LENGTH_SHORT).show();

                }
                else {
                    boolean matchVal = rd.loginIn(emailDataL,passwordDataL);
                    if(matchVal == true) {
                        Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                        Intent in = new Intent(MainActivity.this, MainActivity3.class);
                        startActivity(in);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "check your username and password..!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });




    }
}