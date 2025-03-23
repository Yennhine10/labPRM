package com.example.nhithuchanh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nhithuchanh.model.Book;

public class AddActivity extends AppCompatActivity {
    private EditText ipAddField1, ipAddField2, ipAddField3, isAddField4, isAddField5;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        database = AppDatabase.getInstance(this);

        ipAddField1 = findViewById(R.id.tx_name);
        ipAddField2 = findViewById(R.id.tx_price);
        ipAddField3 = findViewById(R.id.tx_quantity);
        isAddField4 = findViewById(R.id.tx_description);
        isAddField5 = findViewById(R.id.tx_location);

    }

        public void addNewData(View view) {
        String t1 = ipAddField1.getText().toString().trim();
        String t2 = ipAddField2.getText().toString().trim();
        String t3 = ipAddField3.getText().toString().trim();
        String t4 = isAddField4.getText().toString().trim();
        String t5 = isAddField5.getText().toString().trim();




        Book b=new Book(0,t1,Double.parseDouble(t2),Integer.parseInt(t3),t4,t5);
        database.bookDao().insert(b);

        Toast.makeText(this,"Thêm thành công",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.putExtra("message","ok");
        setResult(100, intent );
        finish();
    }


//    public void addNewData(View view) {
//        String t1 = ipAddField1.getText().toString().trim();
//        String t2 = ipAddField2.getText().toString().trim();
//        String t3 = ipAddField3.getText().toString().trim();
//        String t4 = isAddField4.getText().toString().trim();
//        String t5 = isAddField5.getText().toString().trim();
//        // Kiểm tra xem có trường nào bị bỏ trống không
//        if (t1.isEmpty() || t2.isEmpty() || t3.isEmpty() || t4.isEmpty() || t5.isEmpty()) {
//            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        try {
//            double price = Double.parseDouble(t2);
//            int quantity = Integer.parseInt(t3);
//
//            Book b = new Book(0, t1, price, quantity, t4, t5);
//            database.bookDao().insert(b);
//
//            Toast.makeText(this, "Thêm thành công!", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent();
//            intent.putExtra("message", "ok");
//            setResult(100, intent);
//            finish();
//        } catch (NumberFormatException e) {
//            Toast.makeText(this, "Giá và số lượng phải là số hợp lệ!", Toast.LENGTH_SHORT).show();
//        }
//
//    }
}