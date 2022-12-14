package com.example.androidproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelperClass extends SQLiteOpenHelper {

    private static int dbVersion=1;
    private static String dbName = "BookClub";
    private static String tableName = "BOOKS";

    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String AUTHOR = "author";
    public static final String PUBLISHER = "publisher";
    public static final String PRICE = "price";

    private static final String CREATE_TABLE = "create Table BOOKS(" +
                                        "Id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                                        "Title TEXT NOT NULL, " +
                                        "Author Text NOT NULL, " +
                                        "Publisher TEXT NOT NULL, " +
                                        "Price INTEGER);";

    private static final String CREATE_TABLE2 = "create Table USER("+"username TEXT NOT NULL, password TEXT NOT NULL);";

    private static SQLiteDatabase sqLiteDatabase;

    public DatabaseHelperClass(Context context) {
        super(context,dbName,null,dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" DROP TABLE IF EXISTS BOOKS");
        onCreate(db);
    }

    // Add dummy user for login
    public void addUser(){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS USER");
        sqLiteDatabase.execSQL(CREATE_TABLE2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("username","pranjal1234");
        contentValues.put("password","P1234");
        sqLiteDatabase.insert("USER",null,contentValues);
        Log.d("0","entered in user table");
    }

    // Return username and password
    public ArrayList retAuth(){
        sqLiteDatabase  = getReadableDatabase();
        ArrayList<String> res = new ArrayList<String>();
        Cursor c = sqLiteDatabase.rawQuery("select * from USER",null);

        if(c.moveToFirst()){
            res.add(c.getString(0));
            res.add(c.getString(1));
        }
        c.close();
        return res;
    }

    // Add book entry
    public void addBook(BookModelClass bookModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.TITLE,  bookModelClass.getTitle());
        contentValues.put(DatabaseHelperClass.AUTHOR, bookModelClass.getAuthor());
        contentValues.put(DatabaseHelperClass.PUBLISHER,  bookModelClass.getPublisher());
        contentValues.put(DatabaseHelperClass.PRICE,  bookModelClass.getPrice());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelperClass.tableName,null,contentValues);
    }

    // Update book entry
    public void updateBook(BookModelClass bookModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.TITLE,  bookModelClass.getTitle());
        contentValues.put(DatabaseHelperClass.AUTHOR, bookModelClass.getAuthor());
        contentValues.put(DatabaseHelperClass.PUBLISHER,  bookModelClass.getPublisher());
        contentValues.put(DatabaseHelperClass.PRICE,  bookModelClass.getPrice());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(DatabaseHelperClass.tableName,contentValues, ID+" = ? ", new String[]{String.valueOf(bookModelClass.getId())});
    }

    // Return specific book entry
    public ArrayList getRow(String IdToGet){
        sqLiteDatabase = getReadableDatabase();
        ArrayList<String> res = new ArrayList<String>();
        String[] args = {IdToGet};
        String query = "SELECT * FROM BOOKS WHERE id = ? ";
        Cursor c = sqLiteDatabase.rawQuery(query, args);
        if(c.moveToFirst()){
            res.add(c.getString(1));
            res.add(c.getString(2));
            res.add(c.getString(3));
            res.add(c.getString(4));
        }
        c.close();
        return res;
    }

    // Return all entries
    public ArrayList<BookModelClass> getBooksList(){
        sqLiteDatabase = getReadableDatabase();
        ArrayList<BookModelClass> booksList = new ArrayList<>();

        Cursor c = sqLiteDatabase.query("BOOKS",null,null,null,null,null,null);
        while(c.moveToNext()){
            BookModelClass B = new BookModelClass();
            B.setId(Integer.parseInt(c.getString(c.getColumnIndexOrThrow("Id"))));
            B.setTitle(c.getString(c.getColumnIndexOrThrow("Title")));
            B.setAuthor(c.getString(c.getColumnIndexOrThrow("Author")));
            B.setPublisher(c.getString(c.getColumnIndexOrThrow("Publisher")));
            B.setPrice(c.getString(c.getColumnIndexOrThrow("Price")));

            booksList.add(B);
        }
        c.close();
        return booksList;
    }

    // Delete book entry
    public void deleteBook(String IdToDelete){
        sqLiteDatabase = this.getWritableDatabase();
        String[] args = {IdToDelete};
        sqLiteDatabase.delete(DatabaseHelperClass.tableName,ID + " = ? ",args);
    }
}
