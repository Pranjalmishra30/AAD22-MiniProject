package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Update_entry extends AppCompatActivity {

    Button btnUpdate,btnGet;
    EditText id,title,author,publisher,price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_entry);
        btnUpdate = findViewById(R.id.Update_btnAdd);
        btnGet = findViewById(R.id.Update_btnGet);
        id = findViewById(R.id.txtId);
        title = findViewById(R.id.txtTitle);
        author =  findViewById(R.id.txtAuthor);
        publisher =  findViewById(R.id.txtPublisher);
        price =  findViewById(R.id.txtPrice);


        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(Update_entry.this);
                String StrId = id.getText().toString();

                ArrayList<String> result = new ArrayList<String>();
                result = databaseHelperClass.getRow(StrId);
                title.setText(result.get(0));
                author.setText(result.get(1));
                publisher.setText(result.get(2));
                price.setText(result.get(3));
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Update_entry.this,"Updated Book",Toast.LENGTH_SHORT).show();
                String stringTitle = title.getText().toString();
                String stringAuthor = author.getText().toString();
                String stringPublisher = publisher.getText().toString();
                String stringPrice = price.getText().toString();
                DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(Update_entry.this);
                BookModelClass bookModelClass = new BookModelClass(stringTitle,stringAuthor,stringPublisher,stringPrice);
                databaseHelperClass.updateBook(bookModelClass);
                finish();
                Intent intent = new Intent(Update_entry.this,Update_entry.class);
                startActivity(intent);


            }
        });
    }
}