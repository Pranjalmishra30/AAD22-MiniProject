package com.example.androidproject;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ListAll extends AppCompatActivity  {
//    implements View.OnClickListener
    ListView l;
    String[] Books = { "Pride and Prejudice", "Charlie and the Chocolate Factory",
            "Great Expectations", "To Kill a Mockingbird", "The Notebook", "A Walk to Remember", "The Fault in Our Stars" };
    String[] Authors ={ "Jane Austen", "Roald Dahl", "Charles Dickens", "Harper Lee", "Nicholas Sparks", "Nicholas Sparks", "John Green"};
    String[] Publisher = {"HarperCollins", "Macmillan", "Penguin", "Scholastic", "Pearson", "McGraw-Hill", "Chronicle"};
    String[] Price ={ "200", "250", "300", "350", "400","450","500"};

//    String Issued[] = {"Nipuna", "Pranjal", "Aman", "Nishtha", "Aditi", "Anjali", "Swarna"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all);
        l = findViewById(R.id.list);
        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(ListAll.this);
        ArrayList<BookModelClass> booksList = new ArrayList<>();
        booksList = databaseHelperClass.getBooksList();
//        Log.d("0",booksList.get(0).getTitle());
//        Log.d("1",booksList.get(1).getTitle());
//        Log.d("2",booksList.get(2).getTitle());
//        Log.d("3",booksList.get(3).getTitle());
        Log.d("length", String.valueOf(booksList.size()));
        BookAdapter bookAdapter = new BookAdapter(this,booksList);
        l.setAdapter(bookAdapter);








//        ArrayList<BookModelClass> bookItemModelArrayList = new ArrayList<>();
//        for(int i=0; i<7; i++){
//            bookItemModelArrayList.add(new BookModelClass(Books[i], Authors[i], Publisher[i], Price[i]));
//        }
//        Log.d("0:",bookItemModelArrayList.get(0).getTitle());
//        Log.d("1:",bookItemModelArrayList.get(1).getTitle());
//        Log.d("2:",bookItemModelArrayList.get(2).getTitle());
//
//        BookAdapter bookAdapter = new BookAdapter(this, bookItemModelArrayList);
//        l.setAdapter(bookAdapter);
    }
}


//These classes are called pojos (plain old java objects).
// These are used to define a collection of related information which can be used to bind that information together and use it to show in Lists or store in databases.
// In a pojo you should define the type of information you are about to show in the list.



//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.widget.ListView;
//
//import java.util.ArrayList;
//
//public class ListAll extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list_all);
//    }
//}