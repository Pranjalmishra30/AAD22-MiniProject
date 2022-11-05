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

    Button btnUpdate,btnGet,btnDelete;
    EditText id,title,author,publisher,price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_entry);
        btnUpdate = findViewById(R.id.Update_btnAdd);
        btnGet = findViewById(R.id.Update_btnGet);
        btnDelete = findViewById(R.id.Update_btnDelete);

        id = findViewById(R.id.txtId);
        title = findViewById(R.id.txtTitle);
        author =  findViewById(R.id.txtAuthor);
        publisher =  findViewById(R.id.txtPublisher);
        price =  findViewById(R.id.txtPrice);


        btnGet.setOnClickListener(view -> {
            DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(Update_entry.this);
            String StrId = id.getText().toString();

            if(StrId.length()<=0){
                Toast.makeText(Update_entry.this, "Enter ID", Toast.LENGTH_SHORT).show();
            }
            else{
                ArrayList<String> result = new ArrayList<String>();
                result = databaseHelperClass.getRow(StrId);
                title.setText(result.get(0));
                author.setText(result.get(1));
                publisher.setText(result.get(2));
                price.setText(result.get(3));
            }

        });

        btnUpdate.setOnClickListener(view -> {
            String stringId = id.getText().toString();
            Integer intId = Integer.parseInt(stringId);
            String stringTitle = title.getText().toString();
            String stringAuthor = author.getText().toString();
            String stringPublisher = publisher.getText().toString();
            String stringPrice = price.getText().toString();

            DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(Update_entry.this);
            BookModelClass bookModelClass = new BookModelClass(intId,stringTitle,stringAuthor,stringPublisher,stringPrice);
            databaseHelperClass.updateBook(bookModelClass);
            Toast.makeText(Update_entry.this,"Updated Book",Toast.LENGTH_SHORT).show();
            finish();
            Intent intent = new Intent(Update_entry.this,Update_entry.class);
            startActivity(intent);
        });

        btnDelete.setOnClickListener(view -> {
            DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(Update_entry.this);
            String StrId = id.getText().toString();
            databaseHelperClass.deleteBook(StrId);
            Toast.makeText(Update_entry.this,"Deleted Book",Toast.LENGTH_SHORT).show();
            finish();
            Intent intent = new Intent(Update_entry.this,Update_entry.class);
            startActivity(intent);
        });
    }
}