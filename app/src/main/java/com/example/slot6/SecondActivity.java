package com.example.slot6;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    // This method will be triggered when the arrow image is clicked
    public void onArrowBackClick(View view) {
        // Navigate back to MainActivity
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        startActivity(intent);

        // Optionally, finish this activity to remove it from the stack
        finish();
    }
}