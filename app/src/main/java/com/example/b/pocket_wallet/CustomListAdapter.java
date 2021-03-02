package com.example.b.pocket_wallet;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by B on 9/19/2018.
 */

class CustomListAdapter extends ArrayAdapter {
    private final Activity context;
    ArrayList<String> Names;
    ArrayList<Integer> imgID;



    public CustomListAdapter(Activity context, ArrayList<String> Names, ArrayList<Integer> imgID) {
        super(context, R.layout.list_group, Names);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.Names=Names;
        this.imgID=imgID;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_group, null,true);

        TextView names = (TextView) rowView.findViewById(R.id.lblListHeader);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.list_img);


        names.setText(Names.get(position));
        imageView.setImageResource(imgID.get(position));

        return rowView;

    }

}
