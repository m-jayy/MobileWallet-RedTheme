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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Toast;

import com.tomer.fadingtextview.FadingTextView;

public class MoviesList extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);//to enable back button in action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
////////////////////////////////////////////////////////////////////////////////////////////////////////////

        String[] texts = {"Movie Tickets","Select Movie"};
        FadingTextView FTV = (FadingTextView) findViewById(R.id.appBar_text);
        FTV.setTexts(texts);

//////////////////////////////////////     Rating    ////////////////////////////////////////////////////////
        RatingBar movie1Rating = (RatingBar) findViewById(R.id.movie_rating_1);
        RatingBar movie2Rating = (RatingBar) findViewById(R.id.movie_rating_2);
        RatingBar movie3Rating = (RatingBar) findViewById(R.id.movie_rating_3);

        movie1Rating.setRating(Float.parseFloat("3.5"));
        movie2Rating.setRating(2);
        movie3Rating.setRating(Float.parseFloat("1.5"));
///////////////////////////////////////////////    Listners   ///////////////////////////////////////////////////

        LinearLayout movie_1 = (LinearLayout) findViewById(R.id.movie_1);
        LinearLayout movie_2 = (LinearLayout) findViewById(R.id.movie_2);
        LinearLayout movie_3 = (LinearLayout) findViewById(R.id.movie_3);


        movie_1.setOnClickListener(this);
        movie_2.setOnClickListener(this);
        movie_3.setOnClickListener(this);
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
/////////////////////////////////////////// for back press button Bar ////////////////////////
        int id=item.getItemId();
        if(id==android.R.id.home)
        {

            finish();
        }
/////////////////////////////////////////// for Search Action Bar ////////////////////////
        if(id==R.id.action_search)
        {
            SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    Toast.makeText(MoviesList.this, query, Toast.LENGTH_SHORT).show();
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
        }
///////////////////////////////////////////////////////////////////////////////////////////////
        return super.onOptionsItemSelected(item);
    }
//////////////////////////////////////// list on click functionaltiy//////////////////////////////////
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.movie_1:
                startActivity(new Intent(getApplicationContext(),Movie_main_page.class));
                break;

            case R.id.movie_2:
                startActivity(new Intent(getApplicationContext(),Movie_main_page.class));
                break;

            case R.id.movie_3:
                startActivity(new Intent(getApplicationContext(),Movie_main_page.class));
                break;


        }

    }
}
