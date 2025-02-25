package com.example.kethopsql;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SumMainActivity extends AppCompatActivity {
    TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum_main);
        txt1=findViewById(R.id.txt1);
        //lay du lieu tu activity A
        Intent intent1=getIntent();
        double so1=intent1.getDoubleExtra("so1",0);
        double so2=intent1.getDoubleExtra("so2",0);
        double tong=so1+so2;
        txt1.setText(String.valueOf(tong));

    }
}