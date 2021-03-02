package com.example.b.pocket_wallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BillPayments_Utilities extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billpayments__utilities);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Bill Payments");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        expListView = (ExpandableListView) findViewById(R.id.lvExp);
////////////////////////////// setting indicator to right of the screen//////////////////////////////////////////////////////
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

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                String selected_group_name = listDataHeader.get(groupPosition);
                String selected_child_name = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);



                switch (selected_group_name)
                {
                    case "Electricity":
                        Intent Electricity = new Intent(getApplicationContext(),BillPayments_Utilities_Electricity.class);
                        Electricity.putExtra("CompanyName",selected_child_name);
                        startActivity(Electricity);
                        break;

                    case "Telephone":
                        Intent feePage = new Intent(getApplicationContext(),BillPayments_Utilities_Telephone.class);
                        feePage.putExtra("CompanyName",selected_child_name);
                        startActivity(feePage);
                        break;

                    case "Internet":
                        Intent Internet = new Intent(getApplicationContext(),BillPayments_Utilities_Internet.class);
                        Internet.putExtra("CompanyName",selected_child_name);
                        startActivity(Internet);
                        break;

                    case "Gas":
                        Intent Gas = new Intent(getApplicationContext(),BillPayments_Utilities_Gas.class);
                        Gas.putExtra("CompanyName",selected_child_name);
                        startActivity(Gas);
                        break;
                    case "Water":
                        Intent Water = new Intent(getApplicationContext(),BillPayments_Utilities_Water.class);
                        Water.putExtra("CompanyName",selected_child_name);
                        startActivity(Water);
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
        listDataHeader.add("Electricity");
        listDataHeader.add("Telephone");
        listDataHeader.add("Internet");
        listDataHeader.add("Gas");
        listDataHeader.add("Water");

        // Adding child data
        List<String> Electricity = new ArrayList<String>();
        Electricity.add("FESCO");
        Electricity.add("GEPCO");
        Electricity.add("HESCO");
        Electricity.add("K-ELECTRIC");

        List<String> Telephone = new ArrayList<String>();
        Telephone.add("PTCL");
        Telephone.add("SCO");

        List<String> Internet = new ArrayList<String>();
        Internet.add("Naya Tel");
        Internet.add("Qubee");
        Internet.add("Wateen");

        List<String> Gas = new ArrayList<String>();
        Gas.add("SNGPL");
        Gas.add("SSGC");


        List<String> Water = new ArrayList<String>();
        Water.add("FWASA");
        Water.add("HWASA");
        Water.add("QWASA");




        listDataChild.put(listDataHeader.get(0), Electricity); // Header, Child data
        listDataChild.put(listDataHeader.get(1), Telephone);
        listDataChild.put(listDataHeader.get(2), Internet);
        listDataChild.put(listDataHeader.get(3), Gas);
        listDataChild.put(listDataHeader.get(4), Water);
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



