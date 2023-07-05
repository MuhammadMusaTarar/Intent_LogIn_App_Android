package com.example.intentloginapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import java.util.Objects;

public class LoggedInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Logged");
        Button Exit = findViewById(R.id.Exit);

        Exit.setOnClickListener(v -> {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            this.finishAffinity();
        });
    }
}