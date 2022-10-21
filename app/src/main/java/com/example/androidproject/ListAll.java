package com.example.androidproject;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

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
        ArrayList<BookModelClass> bookItemModelArrayList = new ArrayList<>();
        for(int i=0; i<7; i++){
            bookItemModelArrayList.add(new BookModelClass(Books[i], Authors[i], Publisher[i], Price[i]));
        }
        BookAdapter bookAdapter = new BookAdapter(this, bookItemModelArrayList);
        l.setAdapter(bookAdapter);
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