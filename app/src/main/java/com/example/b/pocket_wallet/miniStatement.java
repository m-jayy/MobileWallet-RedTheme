package com.example.b.pocket_wallet;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;


import java.util.ArrayList;

public class miniStatement extends AppCompatActivity {

    ListView listView;
    CustomMiniStatementListAdapter adapter;
    ArrayList<String> transactionTitle,transactionAmount,transactionDate;
    ArrayList<Integer> imgID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ministatement);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Mobile Wallet");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        transactionTitle = new ArrayList<String>();
        transactionAmount = new ArrayList<String>();
        transactionDate = new ArrayList<String>();
        imgID = new ArrayList<Integer>();

        displayOperation();

    }

    private void displayOperation() {

        Resources res = this.getResources();
        int resID = res.getIdentifier("ministatement", "drawable", this.getPackageName());


        transactionTitle.add("Electricity Bill");
        transactionAmount.add("RS. 20312");
        transactionDate.add("27/8/2018");
        imgID.add(resID);

        transactionTitle.add("Easy Load");
        transactionAmount.add("RS. 500");
        transactionDate.add("23/8/2018");
        imgID.add(resID);

        transactionTitle.add("Jubilee Insurance");
        transactionAmount.add("RS. 123300");
        transactionDate.add("22/8/2018");
        imgID.add(resID);

        display();
    }

    public void display()
    {

        listView= (ListView) findViewById(R.id.lvExp);
        adapter=new CustomMiniStatementListAdapter(this, transactionTitle,transactionAmount,transactionDate,imgID);
        listView.setAdapter(adapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//
//                switch (IncuranceCompanies.get(position).toString())
//                {
//                    case "Utilities":
//                        Intent Utility = new Intent(getApplicationContext(),BillPayments_Utilities.class);
//                        startActivity(Utility);
//                        break;
//                    case "Mobile Topups":
//                        Intent Topups = new Intent(getApplicationContext(),BillPayments_MobileTopups.class);
//                        startActivity(Topups);
//                        break;
//
//                }

//            }
//        });

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
