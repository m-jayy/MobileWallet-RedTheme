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

import com.tomer.fadingtextview.FadingTextView;

public class BusList extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);//to enable back button in action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
////////////////////////////////////////////////////////////////////////////////////////////////////////////

        String[] texts = {"Bus Tickets","Select Company"};
        FadingTextView FTV = (FadingTextView) findViewById(R.id.appBar_text);
        FTV.setTexts(texts);

//////////////////////////////////////     Rating    ////////////////////////////////////////////////////////
//        RatingBar movie1Rating = (RatingBar) findViewById(R.id.bus_rating_1);
//        RatingBar movie2Rating = (RatingBar) findViewById(R.id.bus_rating_2);
//        RatingBar movie3Rating = (RatingBar) findViewById(R.id.bus_rating_3);
//
//        movie1Rating.setRating(Float.parseFloat("3.5"));
//        movie2Rating.setRating(2);
//        movie3Rating.setRating(Float.parseFloat("1.5"));
///////////////////////////////////////////////    Listners   ///////////////////////////////////////////////////

        LinearLayout bus_1 = (LinearLayout) findViewById(R.id.bus_1);
        LinearLayout bus_2 = (LinearLayout) findViewById(R.id.bus_2);
        LinearLayout bus_3 = (LinearLayout) findViewById(R.id.bus_3);


        bus_1.setOnClickListener(this);
        bus_2.setOnClickListener(this);
        bus_3.setOnClickListener(this);


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
            case R.id.bus_1:
                startActivity(new Intent(getApplicationContext(),Bus_main_page.class));
                break;

            case R.id.bus_2:
                startActivity(new Intent(getApplicationContext(),Bus_main_page.class));
                break;

            case R.id.bus_3:
                startActivity(new Intent(getApplicationContext(),Bus_main_page.class));
                break;


        }

    }
}
