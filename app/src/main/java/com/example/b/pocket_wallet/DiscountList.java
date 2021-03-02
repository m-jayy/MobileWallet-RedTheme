package com.example.b.pocket_wallet;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Toast;

import com.tomer.fadingtextview.FadingTextView;

public class DiscountList extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Discounts");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);//to enable back button in action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////    Listners   ///////////////////////////////////////////////////

        LinearLayout discount_1 = (LinearLayout) findViewById(R.id.discount_1);
        LinearLayout discount_2 = (LinearLayout) findViewById(R.id.discount_2);
        LinearLayout discount_3 = (LinearLayout) findViewById(R.id.discount_3);


        discount_1.setOnClickListener(this);
        discount_2.setOnClickListener(this);
        discount_3.setOnClickListener(this);


        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////




    }
    /////////////////////////// for creation app bar options/////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tickets_list, menu);
        return super.onCreateOptionsMenu(menu);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();

        if(id==android.R.id.home)
        {
            finish();
        }

        if(id==R.id.action_search)
        {
            SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    Toast.makeText(DiscountList.this, query, Toast.LENGTH_SHORT).show();
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.discount_1:
                startActivity(new Intent(getApplicationContext(),Discount_main_page.class));
                break;

            case R.id.discount_2:
                startActivity(new Intent(getApplicationContext(),Discount_main_page.class));
                break;

            case R.id.discount_3:
                startActivity(new Intent(getApplicationContext(),Discount_main_page.class));
                break;


        }

    }
}
