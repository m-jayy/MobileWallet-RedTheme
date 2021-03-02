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

public class BillPayments_MobileTopups extends AppCompatActivity {

    ListView listView;
    CustomListAdapter adapter;
    ArrayList<String> Companies;
    ArrayList<Integer> img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billpayments__mobiletopups);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Bill Payments");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Companies = new ArrayList<String>();
        img = new ArrayList<Integer>();


        displayCompaniesOperation();

    }

    private void displayCompaniesOperation() {

        Resources res = this.getResources();

        Companies.add("Ufone");
        img.add(res.getIdentifier("ufone", "drawable", this.getPackageName()));

        Companies.add("Zong");
        img.add(res.getIdentifier("zong", "drawable", this.getPackageName()));

        Companies.add("Telenor");
        img.add(res.getIdentifier("telenor", "drawable", this.getPackageName()));

        Companies.add("Warid");
        img.add(res.getIdentifier("warid", "drawable", this.getPackageName()));


        display();
    }

    public void display()
    {

        listView= (ListView) findViewById(R.id.lvExp);
        adapter=new CustomListAdapter(this, Companies,img);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent Gas = new Intent(getApplicationContext(),BillPayments_MobileTopups_Company.class);
                Gas.putExtra("CompanyName",Companies.get(position).toString());
                startActivity(Gas);
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
