package com.example.androidproject;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class BookAdapter extends ArrayAdapter<BookModelClass> {
    private final Context mContext;
    private final ArrayList<BookModelClass> bookList;

    public BookAdapter(@NonNull Context context, ArrayList<BookModelClass> list) {
        super(context,0, list);
        mContext = context;
        bookList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);

        BookModelClass current = bookList.get(position);

        TextView book = listItem.findViewById(R.id.LBook);
        book.setText(current.getTitle());

        TextView id = listItem.findViewById(R.id.LId);
        id.setText("ID: "+ String.valueOf(current.getId()));

        TextView author = listItem.findViewById(R.id.LAuthor);
        author.setText(current.getAuthor());

        TextView publisher = listItem.findViewById(R.id.LPublisher);
        publisher.setText(current.getPublisher());

        TextView price = listItem.findViewById(R.id.LPrice);
        price.setText(current.getPrice()+" Rs.");


//
        if (position % 2 == 1) {
            listItem.setBackgroundColor(Color.parseColor("#9933FF"));
        } else {
            listItem.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        }
        return listItem;
    }
}
