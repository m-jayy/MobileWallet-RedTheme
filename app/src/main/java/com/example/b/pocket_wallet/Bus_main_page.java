package com.example.b.pocket_wallet;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


import com.jaeger.library.StatusBarUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Bus_main_page extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Calendar myCalendar;
    View bookingAlert,bookingHeader;
    AlertDialog alert;
    EditText CNIC_Handler;
    TextView Date_Handler;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_main_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Daewoo");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        StatusBarUtil.setTransparent(Bus_main_page.this);

        myCalendar = Calendar.getInstance();

        CNIC_Handler = (EditText) findViewById(R.id.CINC) ;
        Date_Handler = (TextView) findViewById(R.id.dateTxtview);
/////////////////////////////////////////////////////////////spinner city from//////////////////////////////////////////////////
        enable_spinnercityfrom();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        enable_spinneSeats();
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        bookingAlert = LayoutInflater.from(Bus_main_page.this).inflate(R.layout.bus_booking_alert, null);
        bookingHeader = LayoutInflater.from(Bus_main_page.this).inflate(R.layout.movie_booking_alert_header, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(Bus_main_page.this);
        builder.setCustomTitle(bookingHeader).setView(bookingAlert);

        alert = builder.create();
////           /////////                ///////////               /////////////               //////////////////////////////////////

        Button bookBus = (Button) findViewById(R.id.bookBus);
        bookBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();

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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        switch (parent.getId()) {

            case R.id.spinnercityfrom:
                enable_spinneCityTo();
                break;
            case R.id.spinneCityTo:
                enable_datebtn();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void enable_spinnercityfrom() {
        Spinner spinnercityfrom =(Spinner) findViewById(R.id.spinnercityfrom);
        String[] cityitems = new String[]{"Rawalpindi", "Islamabad", "Lahore", "Karachi", "Multan"};
        ArrayAdapter<String> cityadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, cityitems);
        spinnercityfrom.setAdapter(cityadapter);

        spinnercityfrom.setOnItemSelectedListener(this);

        enable_spinneCityTo();
    }
    private void enable_spinneCityTo() {

        final Spinner spinneCityTo =(Spinner) findViewById(R.id.spinneCityTo);
        String[] tocityitems = new String[]{"Islamabad", "Lahore", "Karachi", "Multan", "Rawalpindi"};
        final ArrayAdapter<String> ToCityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, tocityitems);
        spinneCityTo.setAdapter(ToCityAdapter);

        spinneCityTo.setOnItemSelectedListener(this);

    }
    private void enable_datebtn() {

        ImageView datebtn = (ImageView) findViewById(R.id.datebtn);

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateTimeLabel();
            }

        };


        datebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Bus_main_page.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });
    }
    private void updateTimeLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        TextView dateTxtview= (TextView) findViewById(R.id.dateTxtview);
        dateTxtview.setText(sdf.format(myCalendar.getTime()));

        enable_spinneTime();
    }
    private void enable_spinneTime() {

        Spinner spinneTime =(Spinner) findViewById(R.id.spinneTime);
        String[] Timeitems = new String[]{ "13:15", "22:45"};
        ArrayAdapter<String> Timeadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Timeitems);
        spinneTime.setAdapter(Timeadapter);
    }
    private void enable_spinneSeats() {
        Spinner spinneSeats =(Spinner) findViewById(R.id.spinneSeats);
        String[] TimeSeats = new String[]{ "1", "2","3","4","5"};
        ArrayAdapter<String> Seatsadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, TimeSeats);
        spinneSeats.setAdapter(Seatsadapter);
    }

    public void Cancel(View view)
    {
        alert.dismiss();
    }
    public void Confirm(View view) {
        alert.dismiss();

        new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Booking Failed..")
                .setContentText("Insufficient Current Balance")
                .show();


//        new AlertDialog.Builder(Bus_main_page.this)
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

    private void attemptLogin() {
        CNIC_Handler.setError(null);
        Date_Handler.setError(null);
        // Store values at the time of the login attempt.
        String var_cnic = CNIC_Handler.getText().toString();
        String var_date = Date_Handler.getText().toString();
        boolean cancel = false;
        View focusView = null;
        // Check for a valid password, if the user entered one.

        // Check for a valid email address.
        if (TextUtils.isEmpty(var_cnic)) {
            CNIC_Handler.setError(getString(R.string.error_field_required));
            focusView = CNIC_Handler;
            cancel = true;
        } else if (!isCNICValid(var_cnic)) {
            CNIC_Handler.setError("This CNIC is invalid");
            focusView = CNIC_Handler;
            cancel = true;
        }

        if (TextUtils.isEmpty(var_date)) {
            Date_Handler.setError(getString(R.string.error_field_required));
            focusView = Date_Handler;
            cancel = true;
        }

        if (cancel) {

            focusView.requestFocus();

        } else {////////////// if all set than start actual work after click listner
            alert.show();
        }
    }
    private boolean isCNICValid(String CNIC) {
        //TODO: Replace this with your own logic
        return CNIC.length()==13;
    }

    }
