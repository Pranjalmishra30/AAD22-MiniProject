package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button button;
    EditText username,pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.login);
        username = findViewById(R.id.Username);
        pwd = findViewById(R.id.pwd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(MainActivity.this);
                String user = username.getText().toString();
                String pass = pwd.getText().toString();

                ArrayList<String> res = new ArrayList<String>();
                res = databaseHelperClass.retAuth();
                Log.d("0",res.get(0));
                Log.d("0",res.get(1));




                openActivity2();
            }
        });
    }

    public void openActivity2(){
        Intent intent = new Intent(this,NewEntry.class);
        startActivity(intent);
    }
}