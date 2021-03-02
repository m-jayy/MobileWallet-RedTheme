package com.example.b.pocket_wallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MoneyTransfer_IntraBFT extends AppCompatActivity {

    ListView listView;
    CustomListAdapter adapter;
    ArrayList<String> Banks;
    ArrayList<Integer> img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moneytransfer_intrabft);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Money Transfer");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Banks = new ArrayList<String>();
        img = new ArrayList<Integer>();


        displayCompaniesOperation();

    }

    private void displayCompaniesOperation() {

        Resources res = this.getResources();

        Banks.add("Allied Bank Limited");
        img.add(res.getIdentifier("allied", "drawable", this.getPackageName()));

        Banks.add("Bank AlFalah");
        img.add(res.getIdentifier("alflah", "drawable", this.getPackageName()));

        Banks.add("Bank Al Habib");
        img.add(res.getIdentifier("al_habib", "drawable", this.getPackageName()));

        Banks.add("Askari Bank ");
        img.add(res.getIdentifier("askari", "drawable", this.getPackageName()));

        Banks.add("Burj Bank");
        img.add(res.getIdentifier("burj", "drawable", this.getPackageName()));

        Banks.add("HBL Bank");
        img.add(res.getIdentifier("hbl", "drawable", this.getPackageName()));

        Banks.add("JS Bank");
        img.add(res.getIdentifier("js", "drawable", this.getPackageName()));

        Banks.add("Allied Bank");
        img.add(res.getIdentifier("allied", "drawable", this.getPackageName()));

        Banks.add("UBL Bank");
        img.add(res.getIdentifier("ubl", "drawable", this.getPackageName()));

        display();
    }

    public void display()
    {

        listView= (ListView) findViewById(R.id.lvExp);
        adapter=new CustomListAdapter(this, Banks,img);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                Intent Bank = new Intent(getApplicationContext(),MoneyTransfer_banktransaction.class);
                Bank.putExtra("BankName",Banks.get(position).toString());
                startActivity(Bank);
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
