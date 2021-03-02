package com.example.b.pocket_wallet;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class BillPayments extends AppCompatActivity {

    ListView listView;
    CustomListAdapter adapter;
    ArrayList<String> IncuranceCompanies;
    ArrayList<Integer> img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billpayments);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Bill Payments");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        IncuranceCompanies = new ArrayList<String>();
        img = new ArrayList<Integer>();


        displayCompaniesOperation();

    }

    private void displayCompaniesOperation() {

        Resources res = this.getResources();

        IncuranceCompanies.add("Utilities");
        img.add(res.getIdentifier("utilities", "drawable", this.getPackageName()));

        IncuranceCompanies.add("Mobile Topups");
        img.add(res.getIdentifier("mobile_topups", "drawable", this.getPackageName()));

        display();
    }

    public void display()
    {

        listView= (ListView) findViewById(R.id.lvExp);
        adapter=new CustomListAdapter(this, IncuranceCompanies,img);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                switch (IncuranceCompanies.get(position).toString())
                {
                    case "Utilities":
                        Intent Utility = new Intent(getApplicationContext(),BillPayments_Utilities.class);
                        startActivity(Utility);
                        break;
                    case "Mobile Topups":
                        Intent Topups = new Intent(getApplicationContext(),BillPayments_MobileTopups.class);
                        startActivity(Topups);
                        break;

                }



            }
        });

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
