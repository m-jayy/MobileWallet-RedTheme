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
import android.widget.EditText;
import android.widget.Spinner;
import com.jaeger.library.StatusBarUtil;


import cn.pedant.SweetAlert.SweetAlertDialog;

public class Discount_main_page extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    View bookingAlert,bookingHeader;
    AlertDialog alert;
    EditText CNIC_Handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount_main_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("STREET STYLE Leather Jacket");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        StatusBarUtil.setTransparent(Discount_main_page.this);


        CNIC_Handler = (EditText) findViewById(R.id.CINC);


/////////////////////////////////////////////////////////////spinner city from//////////////////////////////////////////////////
        enable_spinnercity();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        enable_spinneColor();
        enable_spinnerQuantity();
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        bookingAlert = LayoutInflater.from(Discount_main_page.this).inflate(R.layout.discount_booking_alert, null);
        bookingHeader = LayoutInflater.from(Discount_main_page.this).inflate(R.layout.movie_booking_alert_header, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(Discount_main_page.this);
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

            case R.id.p_color:
                enable_spinne_p_size();
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void enable_spinnercity() {
        Spinner spinnercityfrom =(Spinner) findViewById(R.id.spinnercity);
        String[] cityitems = new String[]{"Rawalpindi", "Islamabad", "Lahore", "Karachi", "Multan"};
        ArrayAdapter<String> cityadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, cityitems);
        spinnercityfrom.setAdapter(cityadapter);
        spinnercityfrom.setOnItemSelectedListener(this);
    }

    private void enable_spinneColor() {

        final Spinner spinneColor =(Spinner) findViewById(R.id.p_color);
        String[] tocityitems = new String[]{"Red", "Black", "Brown", "Orange"};
        final ArrayAdapter<String> ToCityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, tocityitems);
        spinneColor.setAdapter(ToCityAdapter);

        spinneColor.setOnItemSelectedListener(this);



    }
    private void enable_spinne_p_size() {
        Spinner spinne_p_size =(Spinner) findViewById(R.id.p_size);
        String[] TimeSeats = new String[]{ "Small","Medium","Large","Extra Large"};
        ArrayAdapter<String> Seatsadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, TimeSeats);
        spinne_p_size.setAdapter(Seatsadapter);
    }



    private void enable_spinnerQuantity() {
        Spinner spinneQuantity =(Spinner) findViewById(R.id.spinneQuantity);
        String[] TimeSeats = new String[]{ "1", "2","3","4","5"};
        ArrayAdapter<String> Seatsadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, TimeSeats);
        spinneQuantity.setAdapter(Seatsadapter);
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


//        new AlertDialog.Builder(Discount_main_page.this)
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

        // Store values at the time of the login attempt.
        String var_cnic = CNIC_Handler.getText().toString();

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
