package com.example.b.pocket_wallet;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by B on 9/24/2018.
 */

class CustomMiniStatementListAdapter extends ArrayAdapter {

    private Activity context;
    ArrayList<String> transactionTitle,transactionAmount,transactionDate;
    ArrayList<Integer> imgID;


    public CustomMiniStatementListAdapter(Activity context, ArrayList<String> transactionTitle, ArrayList<String> transactionAmount, ArrayList<String> transactionDate, ArrayList<Integer> imgID) {
        super(context, R.layout.list_ministatement_row, transactionTitle);

        this.context=context;
        this.transactionTitle=transactionTitle;
        this.transactionAmount=transactionAmount;
        this.transactionDate=transactionDate;
        this.imgID=imgID;
    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_ministatement_row, null,true);

        TextView amount = (TextView) rowView.findViewById(R.id.amount);
        TextView title = (TextView) rowView.findViewById(R.id.title);
        TextView date = (TextView) rowView.findViewById(R.id.date);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);


        amount.setText(transactionAmount.get(position));
        title.setText(transactionTitle.get(position));
        date.setText(transactionDate.get(position));
        imageView.setImageResource(imgID.get(position));


        return rowView;

    }

}
