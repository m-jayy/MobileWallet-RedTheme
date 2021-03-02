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

public class MoneyTransfer extends AppCompatActivity {

    ListView listView;
    CustomListAdapter adapter;
    ArrayList<String> type;
    ArrayList<Integer> img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moneytransfer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Money Transfer");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        type = new ArrayList<String>();
        img = new ArrayList<Integer>();


        displayCompaniesOperation();

    }

    private void displayCompaniesOperation() {

        Resources res = this.getResources();

        type.add("Inter Bank Funds Transfer");
        img.add(res.getIdentifier("inter_banktransfer", "drawable", this.getPackageName()));

        type.add("Intra Bank Funds Transfer");
        img.add(res.getIdentifier("intra_banktransfer", "drawable", this.getPackageName()));

        display();
    }

    public void display()
    {

        listView= (ListView) findViewById(R.id.lvExp);
        adapter=new CustomListAdapter(this, type,img);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                switch (type.get(position).toString())
                {
                    case "Inter Bank Funds Transfer":
                        Intent Inter = new Intent(getApplicationContext(),MoneyTransfer_IntraBFT.class);
                        startActivity(Inter);


                        break;
                    case "Intra Bank Funds Transfer":
                        Intent Intra = new Intent(getApplicationContext(),MoneyTransfer_banktransaction.class);
                        Intra.putExtra("BankName","Apna Bank");
                        startActivity(Intra);
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
