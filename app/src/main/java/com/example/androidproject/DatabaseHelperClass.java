package com.example.androidproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
        db.execSQL(CREATE_TABLE2);

        // Login and password added in table
        ContentValues contentValues = new ContentValues();
        contentValues.put("username","pranjal1234");
        contentValues.put("password","P1234");
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert("USER",null,contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" DROP TABLE IF EXISTS BOOKS");
        onCreate(db);
    }

    public ArrayList retAuth(){
        sqLiteDatabase  = getReadableDatabase();
        ArrayList<String> res = new ArrayList<String>();
        Cursor c = sqLiteDatabase.rawQuery("select * from USER",null);

        res.add(c.getString(0));
        res.add(c.getString(1));
        c.close();
        return res;
    }


    public void addBook(BookModelClass bookModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.TITLE,  BookModelClass.getTitle());
        contentValues.put(DatabaseHelperClass.AUTHOR, BookModelClass.getAuthor());
        contentValues.put(DatabaseHelperClass.PUBLISHER,  BookModelClass.getPublisher());
        contentValues.put(DatabaseHelperClass.PRICE,  BookModelClass.getPrice());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelperClass.tableName,null,contentValues);

    }

    public void updateBook(BookModelClass bookModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.TITLE,  BookModelClass.getTitle());
        contentValues.put(DatabaseHelperClass.AUTHOR, BookModelClass.getAuthor());
        contentValues.put(DatabaseHelperClass.PUBLISHER,  BookModelClass.getPublisher());
        contentValues.put(DatabaseHelperClass.PRICE,  BookModelClass.getPrice());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(DatabaseHelperClass.tableName,contentValues, ID+" = ? ", new String[]{String.valueOf(BookModelClass.getId())});

    }

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

    public ArrayList<BookModelClass> getBooksList(){
        sqLiteDatabase = getReadableDatabase();
        ArrayList<BookModelClass> booksList = new ArrayList<>();
        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM BOOKS",null);
        if(c.moveToFirst()){
            while(!c.isAfterLast()){
                booksList.add(new BookModelClass(c.getString(1),c.getString(2),c.getString(3),c.getString(4)));
                c.moveToNext();
            }
        }
        c.close();
        return booksList;
    }
}
