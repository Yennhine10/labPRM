package com.example.nhithuchanh;



import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.nhithuchanh.model.Book;

import java.util.List;

@Dao
public interface BookDAO {
    @Query("SELECT * FROM books")
    List<Book> getAll();

    @Insert
    void insert(Book book);

    @Delete
    void delete(Book book);

    @Update
    void update(Book book);


    @Query("SELECT * FROM books WHERE name LIKE '%' || :name || '%' ")
    List<Book> searchByName(String name);

//    @Query("SELECT * FROM books WHERE Name LIKE '%' || :query || '%' " +
//            "OR Price LIKE '%' || :query || '%' " +
//            "OR Location LIKE '%' || :query || '%' " +
//            "OR Description LIKE '%' || :query || '%'")
//    List<Book> searchBook(String query);


}
