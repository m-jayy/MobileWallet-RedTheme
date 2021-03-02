package com.example.b.pocket_wallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;

public class Payments extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Payments");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        expListView = (ExpandableListView) findViewById(R.id.lvExp);
//////////////////////////////// setting indicator to right of the screen//////////////////////////////////////////////////////
        DisplayMetrics metrics;
        int width;
        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        width = metrics.widthPixels;

        expListView.setIndicatorBounds(width - GetDipsFromPixel(50), width - GetDipsFromPixel(10));

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        expListView.setAdapter(listAdapter);

        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                String selected_group_name = listDataHeader.get(groupPosition);
                String selected_child_name = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);



                switch (selected_group_name)
                {
                    case "Donations":
                        Intent donationsPage = new Intent(getApplicationContext(),Payments_Donations.class);
                        donationsPage.putExtra("CompanyName",selected_child_name);
                        startActivity(donationsPage);
                        break;

                    case "Fee Collection":
                        Intent feePage = new Intent(getApplicationContext(),Payments_FeeCollection.class);
                        feePage.putExtra("SchoolName",selected_child_name);
                        startActivity(feePage);
                        break;

                    case "Amount Transfer":
                        Intent TransferPage = new Intent(getApplicationContext(),Payments_AmountTransfer.class);
                        startActivity(TransferPage);
                        break;
                }
                return false;
            }
        });
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Donations");
        listDataHeader.add("Fee Collection");
        listDataHeader.add("Amount Transfer");

        // Adding child data
        List<String> donations = new ArrayList<String>();
        donations.add("Edhi");
        donations.add("SKMCH");
        donations.add("SHIFA");
        donations.add("Sahara");

        List<String> FeeCollection = new ArrayList<String>();
        FeeCollection.add("Root School");
        FeeCollection.add("Spirit School");
        FeeCollection.add("Ace School");

        List<String> MoneyTransfer = new ArrayList<String>();
        MoneyTransfer.add("User Money Transfer");

        listDataChild.put(listDataHeader.get(0), donations); // Header, Child data
        listDataChild.put(listDataHeader.get(1), FeeCollection);
        listDataChild.put(listDataHeader.get(2), MoneyTransfer);
    }

    public int GetDipsFromPixel(float pixels)
    {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();
        if(id==android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}



