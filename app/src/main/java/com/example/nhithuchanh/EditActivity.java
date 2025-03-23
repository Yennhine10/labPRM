package com.example.nhithuchanh;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nhithuchanh.model.Book;

public class EditActivity extends AppCompatActivity {
    private EditText ip1,ip2,ip3,ip4,ip5;
    private Book receiveData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit);

        ip1 = findViewById(R.id.tx_name);
        ip2 = findViewById(R.id.tx_price);
        ip3 = findViewById(R.id.tx_quantity);
        ip4 = findViewById(R.id.tx_description);
        ip5 = findViewById(R.id.tx_location);



        if(getIntent() != null){
            receiveData = (Book) getIntent().getSerializableExtra("dulieu");
            ip1.setText(receiveData.getName());
            ip2.setText(String.valueOf(receiveData.getPrice()));
            ip3.setText(String.valueOf(receiveData.getQuantity()));
            ip4.setText(receiveData.getDescription());
            ip5.setText(receiveData.getLocation());
        }
    }
    public void update(View view){
        String t1 = ip1.getText().toString().trim();
        String t2 = ip2.getText().toString().trim();
        String t3 = ip3.getText().toString().trim();
        String t4 = ip4.getText().toString().trim();
        String t5 = ip5.getText().toString().trim();

        Log.d("d","update"+t1);
        Log.d("d","update"+t2);
        Log.d("d","update"+t3);

        receiveData.setName(t1);
        receiveData.setPrice(Double.parseDouble(t2));
        receiveData.setQuantity(Integer.parseInt(t3));
        receiveData.setDescription(t4);
        receiveData.setLocation(t5);

        AppDatabase database = AppDatabase.getInstance(this);
        database.bookDao().update(receiveData);
        Toast.makeText(this, "Update thanh cong", Toast.LENGTH_SHORT).show();
        finish();
    }
}