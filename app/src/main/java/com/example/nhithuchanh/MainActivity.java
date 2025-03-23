package com.example.nhithuchanh;

import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.nhithuchanh.model.Book;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private List<Book> myList;
    private AppDatabase database;
    private SearchView searchView;
    private List<Book> searchList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView = findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Log.d("demo",""+s);
                searchList = new ArrayList<>();
                searchList = database.bookDao().searchByName(s);
//                searchList = database.eventDAO().searchEvent(s);
//                if (searchList.isEmpty()) {
//                    Toast.makeText(MainActivity.this, "Not found", Toast.LENGTH_SHORT).show();
//                }
                // Gán Adapter vào RecyclerView
                myAdapter = new MyAdapter(searchList);
                recyclerView.setAdapter(myAdapter);
                return false;
            }
        });

        database = AppDatabase.getInstance(this);


        // định dạng recycleview
        recyclerView = findViewById(R.id.danhsachsp); // trùng lới id danh sách
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        // khai báo list
        myList = new ArrayList<>();
        loadList();

    }
    public void goAddPage(View view) {
        Intent intent = new Intent(this, AddActivity.class); //AddActivity là màn hình cần chuyển sang
        startActivity(intent);
    }
    public void goEditPage(View view) {
//        Book demoData = new Book(1, "Book 1", 10.0, 10, "Description 1", "Location 1");
//
//        Intent intent = new Intent(this, EditActivity.class); //AddActivity là màn hình cần chuyển sang
//        intent.putExtra("dulieu", demoData);
//        startActivityForResult(intent, 100);

    }
    public void loadList(){
        myList=database.bookDao().getAll();

        // Gán Adapter vào RecyclerView
        myAdapter = new MyAdapter(myList);
        recyclerView.setAdapter(myAdapter);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data, @NonNull ComponentCaller caller) {
        super.onActivityResult(requestCode, resultCode, data, caller);
        Log.d("d","man hinh dc goi");

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadList();
        Log.d("d","onResume");
    }
}
