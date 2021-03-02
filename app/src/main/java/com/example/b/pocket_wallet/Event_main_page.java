package com.example.b.pocket_wallet;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.jaeger.library.StatusBarUtil;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Event_main_page extends AppCompatActivity {
    View bookingAlert,bookingHeader;
    AlertDialog alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_main_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        StatusBarUtil.setTransparent(Event_main_page.this);

        Spinner spinneSeats =(Spinner) findViewById(R.id.spinneSeats);
        String[] TimeSeats = new String[]{ "1", "2","3","4","5"};
        ArrayAdapter<String> Seatsadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, TimeSeats);
        spinneSeats.setAdapter(Seatsadapter);


        Button bookMovie = (Button) findViewById(R.id.bookMovie);
        bookMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.show();
            }
        });

        bookingAlert = LayoutInflater.from(Event_main_page.this).inflate(R.layout.event_booking_alert, null);
        bookingHeader = LayoutInflater.from(Event_main_page.this).inflate(R.layout.movie_booking_alert_header, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(Event_main_page.this);
        builder.setCustomTitle(bookingHeader).setView(bookingAlert);

        alert = builder.create();

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

    public void Cancel(View view)
    {
        alert.dismiss();
    }

    public void Confirm(View view)
    {
        alert.dismiss();

        new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Booking Failed..")
                .setContentText("Insufficient Current Balance")
                .show();


//        new AlertDialog.Builder(Event_main_page.this)
//                .setTitle("Booking Failed")
//                .setMessage("Ops Sorry Insufficient Current Balance.")
//                .setCancelable(false)
//                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                }).show();

    }
}
