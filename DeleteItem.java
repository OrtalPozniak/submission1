package com.example.sub1fruits;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class DeleteItem implements View.OnLongClickListener {
    private MyAdapter _adapter;//the bridge between the deleteitem and the arraylist
    private int _position;//who we want to delete(the one we click on it)

    public DeleteItem(MyAdapter _adapter, int _position) {
        this._adapter = _adapter;
        this._position = _position;
    }
        @Override
        public boolean onLongClick(View view) {
            AlertDialog.Builder b = new AlertDialog.Builder(_adapter._context);
            b.setTitle("Delete '" + _adapter._objects.get(_position).get_name() + "'");
            b.setMessage("Are you sure you want to delete?");
            b.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    Toast.makeText(_adapter._context, "Item: " + _adapter._objects.get(_position).get_name() +" Deleted", Toast.LENGTH_LONG).show();
                    _adapter.remove(_adapter._objects.get(_position));
                }
            });
            b.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(_adapter._context, "will not delete item: " + _adapter._objects.get(_position).get_name(), Toast.LENGTH_LONG).show();
                    dialogInterface.dismiss();
                }
            });

            AlertDialog alert = b.create();
            alert.show();
            return true;
        }
}
