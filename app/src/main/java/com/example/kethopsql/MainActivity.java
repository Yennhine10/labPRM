package com.example.kethopsql;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //khai bao cac control
    EditText edit1,edit2;
    Button btn;
    TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        // dinh nghia cac control
        edit1=findViewById(R.id.edit1);
        edit2=findViewById(R.id.edit2);
        btn=findViewById(R.id.btn);
         //xu ly su kien click Button
        btn.setOnClickListener(v-> {
        // dinh huong goi tu A den B
            Intent intent=new Intent(MainActivity.this,SumMainActivity.class);
            //dua du lieu vao Intent
            intent.putExtra("so1",Double.parseDouble(edit1.getText().toString()));
            intent.putExtra("so2",Double.parseDouble(edit2.getText().toString()));
            //goi activiti B
            startActivity(intent);
        });
    }
    //dinh nghia ham tinh tong
//    private void TinhTong() {
//        //lay ve du lieu nhap vao o thu nhat va chuyen sang kieu so
//       double a=  Double.parseDouble(edit1.getText().toString());
//        //lay ve du lieu nhap vao o thu hai va chuyen sang kieu so
//        double b=  Double.parseDouble(edit2.getText().toString());
//        double tong=a+ b ;// thuc hien tinh tong
//        txt1.setText(String.valueOf(tong));//dua ket qua ra man hinh
//
//    }
}