package com.example.androidproject;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewEntry extends AppCompatActivity {
    Button buttonAdd,buttonUpdate,buttonList;
    EditText title,author,publisher,price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);

        buttonAdd = findViewById(R.id.btnSubmit);
        buttonUpdate = findViewById(R.id.btnUpdate);
        buttonList = findViewById(R.id.btnList);

        title =  findViewById(R.id.txtTitle);
        author =  findViewById(R.id.txtAuthor);
        publisher =  findViewById(R.id.txtPublisher);
        price =  findViewById(R.id.txtPrice);


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringTitle = title.getText().toString();
                String stringAuthor = author.getText().toString();
                String stringPublisher = publisher.getText().toString();
                String stringPrice = price.getText().toString();

                if (stringTitle.length() <= 0 || stringAuthor.length()<=0 || stringPublisher.length()<=0 || stringPrice.length()<=0) {
                    Toast.makeText(NewEntry.this, "Enter all fields", Toast.LENGTH_SHORT).show();
                } else {

                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(NewEntry.this);
                    BookModelClass bookModelClass = new BookModelClass(stringTitle, stringAuthor, stringPublisher, stringPrice);
                    databaseHelperClass.addBook(bookModelClass);
                    Toast.makeText(NewEntry.this, "Added Book", Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent = new Intent(NewEntry.this, NewEntry.class);
                    startActivity(intent);
                }
            }

        });


        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewEntry.this,Update_entry.class);
                startActivity(intent);
            }
        });

        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewEntry.this,ListAll.class);
                startActivity(intent);
            }
        });

    }

    public void openUpdatePage(){

    }

}