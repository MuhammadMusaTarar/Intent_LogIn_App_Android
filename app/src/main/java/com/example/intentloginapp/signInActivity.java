package com.example.intentloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signInActivity extends AppCompatActivity {
    Intent loggedInActivity, stay;
    EditText emailID, passcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        emailID = findViewById(R.id.UserName);
        passcode = findViewById(R.id.password);
        checkDataEntered();

        Button signIn = findViewById(R.id.signIn);
        signIn.setOnClickListener(v -> {
            if (isEmpty(emailID)){
                stay = new Intent(signInActivity.this, signInActivity.class);
                startActivity(stay);
                Toast.makeText(getApplicationContext(), "Must Enter Email to SignIn", Toast.LENGTH_SHORT).show();
            }

            else if (isEmpty(passcode)){
                stay = new Intent(signInActivity.this, signInActivity.class);
                startActivity(stay);
                Toast.makeText(getApplicationContext(), "Must Enter Passcode to SignIn", Toast.LENGTH_SHORT).show();
            }

            else {
                loggedInActivity = new Intent(signInActivity.this, LoggedInActivity.class);
                startActivity(loggedInActivity);
            }
        });
    }

    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered() {
        if (isEmpty(passcode)){
            passcode.setError("Password is required!");
        }
        if (isEmpty(emailID)){
            emailID.setError("Email is required");
        }
    }
}