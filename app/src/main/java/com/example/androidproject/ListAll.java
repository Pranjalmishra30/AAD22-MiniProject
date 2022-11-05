package com.example.androidproject;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ListAll extends AppCompatActivity  {
    ListView l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all);
        l = findViewById(R.id.list);
        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(ListAll.this);
        ArrayList<BookModelClass> booksList = new ArrayList<>();

        booksList = databaseHelperClass.getBooksList();
        BookAdapter bookAdapter = new BookAdapter(this,booksList);
        l.setAdapter(bookAdapter);

    }
}


