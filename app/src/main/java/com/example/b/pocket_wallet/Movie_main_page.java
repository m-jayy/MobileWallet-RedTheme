package com.example.b.pocket_wallet;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
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
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Movie_main_page extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Calendar myCalendar;
    View bookingAlert,bookingHeader;
    AlertDialog alert;
    TextView Date_Handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_main_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Logan");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        StatusBarUtil.setTransparent(Movie_main_page.this);

        myCalendar = Calendar.getInstance();

        Date_Handler = (TextView) findViewById(R.id.dateTxtview);
/////////////////////////////////////////////////////////////spinner city from//////////////////////////////////////////////////
        enable_spinnercity();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       enable_spinneSeats();
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        bookingAlert = LayoutInflater.from(Movie_main_page.this).inflate(R.layout.movie_booking_alert, null);
        bookingHeader = LayoutInflater.from(Movie_main_page.this).inflate(R.layout.movie_booking_alert_header, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(Movie_main_page.this);
        builder.setCustomTitle(bookingHeader).setView(bookingAlert);

        alert = builder.create();
////           /////////                ///////////               /////////////               //////////////////////////////////////

        Button bookBus = (Button) findViewById(R.id.bookMovie);
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

            case R.id.spinnercity:
                enable_cinema();
                break;
            case R.id.spinneCinema:
                enable_datebtn();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    private void enable_spinnercity() {
        Spinner spinnercity=(Spinner) findViewById(R.id.spinnercity);
        String[] cityitems = new String[]{"Rawalpindi", "Islamabad", "Lahore", "Karachi", "Multan"};
        ArrayAdapter<String> cityadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, cityitems);
        spinnercity.setAdapter(cityadapter);

        spinnercity.setOnItemSelectedListener(this);

        enable_cinema();
    }
    private void enable_cinema() {
        Spinner spinnercinema=(Spinner) findViewById(R.id.spinneCinema);
        String[] cinemaitems = new String[]{"Cinepax", "Cinegold", "Prince Cinepas ", "The Arena", "Sozo World"};
        ArrayAdapter<String> cityadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, cinemaitems);
        spinnercinema.setAdapter(cityadapter);

        spinnercinema.setOnItemSelectedListener(this);
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
                new DatePickerDialog(Movie_main_page.this, date, myCalendar
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

        Date_Handler.setError(null);
        // Store values at the time of the login attempt.
        String var_date = Date_Handler.getText().toString();
        boolean cancel = false;
        View focusView = null;

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
