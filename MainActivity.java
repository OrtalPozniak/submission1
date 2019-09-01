package com.example.sub1fruits;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Fruits> fruitList=new ArrayList<>();  //here i'm adding the fruits class into arraylist from hip to stak
        fruitList.add(new Fruits("strawberry",32.5f,R.drawable.strawberry));//here i'm setting the first eivar to the maarach
        fruitList.add(new Fruits("watermelon",30.4f,R.drawable.watermelon));
        fruitList.add(new Fruits("cherry",50f,R.drawable.cherry));
        fruitList.add(new Fruits("grapes",66.9f,R.drawable.grapes));
        fruitList.add(new Fruits("peach",39.4f,R.drawable.peach));
        fruitList.add(new Fruits("apple",52.1f,R.drawable.apple));
        fruitList.add(new Fruits("pineapple",50f,R.drawable.pineapple));

        MyAdapter myAdapter=new MyAdapter(this,R.layout.row,fruitList); //put our addapter into a short name

        ListView lv=findViewById(R.id.allTheListView); //here we dentify the show of the list view
        lv.setAdapter(myAdapter);//and here we are connecting our adapter into our listview

        lv.setClickable(true);//makes the list clickable,the color is changing


    }

}
