package com.example.sub1fruits;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends ArrayAdapter {
    public final static String FRUIT_NAME_INTENT_KEY = "MyAdapter.FRUIT_NAME_INTENT_KEY";
    public final static String FRUIT_CALORIES_INTENT_KEY = "MyAdapter.FRUIT_CALORIES_INTENT_KEY";
    public final static String FRUIT_IMAGE_INTENT_KEY = "MyAdapter.FRUIT_IMAGE_INTENT_KEY";

    Context _context;
    int _layout;
    List<Fruits> _objects;


    public MyAdapter(Context context, int layout, List objects) {
        super(context, layout, objects);
        _context = context;
        _layout = layout;
        _objects = objects;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View result = convertView;
        if (result == null) {// yaanu if i see a empty raw go for it and start drawing
            result = LayoutInflater.from(_context).inflate(R.layout.row, parent, false);
        }
        ImageView fruitImage = result.findViewById(R.id.fruitImage); //into the image view on the result position we got we connect the id of the image part
        fruitImage.setImageResource(_objects.get(position).get_idimg());//here from the show of the objects we take the specific position and id

        TextView fruitName = result.findViewById(R.id.descName);//into the text view (name)on the result position we got we connect the name id of the text name part
        fruitName.setText(_objects.get(position).get_name());//here we take the specific text name and set the text

        TextView fruitCalories = result.findViewById(R.id.descCalories);//into the text view on the result position we got we connect the id of the text description of calories part
        fruitCalories.setText(_objects.get(position).get_calories() + " Calories");//here we set the description calories text we see on the screen in the first activity


        result.setOnLongClickListener(new DeleteItem(this, position));//here we connect the delete item class and get a place in the memory for him

        result.setOnClickListener(new View.OnClickListener() {//this click-function takes me to a new window with a short click
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(_context, Main2Activity.class);
                intent.putExtra(FRUIT_NAME_INTENT_KEY, _objects.get(position).get_name());
                intent.putExtra(FRUIT_CALORIES_INTENT_KEY, String.valueOf(_objects.get(position).get_calories()) );
                intent.putExtra(FRUIT_IMAGE_INTENT_KEY, _objects.get(position).get_idimg());
                _context.startActivity(intent);
            }
        });


        return result;
    }

}
