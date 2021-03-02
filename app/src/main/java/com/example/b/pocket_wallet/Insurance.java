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

public class Insurance extends AppCompatActivity {
    ListView listView;
    CustomListAdapter adapter;
    ArrayList<String> IncuranceCompanies;
    ArrayList<Integer> imgID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Insurance");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        IncuranceCompanies = new ArrayList<String>();
        imgID = new ArrayList<Integer>();


        displayCompaniesOperation();

    }

    private void displayCompaniesOperation() {

        Resources res = this.getResources();

        IncuranceCompanies.add("Jubilee Insurance");
        imgID.add(res.getIdentifier("jubilee_li", "drawable", this.getPackageName()));


        IncuranceCompanies.add("United Insurance");
        imgID.add(res.getIdentifier("united_li", "drawable", this.getPackageName()));

        IncuranceCompanies.add("State Insurance");
        imgID.add(res.getIdentifier("state_li", "drawable", this.getPackageName()));

        IncuranceCompanies.add("BiralSun Insurance");
        imgID.add(res.getIdentifier("biral_li", "drawable", this.getPackageName()));

        display();
    }

    public void display()
    {

        listView= (ListView) findViewById(R.id.lvExp);
        adapter=new CustomListAdapter(this, IncuranceCompanies,imgID);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(getApplicationContext(),Insurance_Company_Page.class);
                intent.putExtra("IncuranceCompany",IncuranceCompanies.get(position).toString());
                startActivity(intent);

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
