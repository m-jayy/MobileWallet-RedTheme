package com.example.b.pocket_wallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class BillPayments_Utilities_Water_Confirmation extends AppCompatActivity {

    String companyName_str, refNumber_str;
    TextView companyName_Handler, reffNumber_Handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billpayments__utilities__water__confirmation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Water");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        companyName_str = getIntent().getStringExtra("ComapnyName");
        refNumber_str = getIntent().getStringExtra("AccountID");

        companyName_Handler = (TextView) findViewById(R.id.ComapnyName);
        reffNumber_Handler = (TextView) findViewById(R.id.reffNum);


        companyName_Handler.setText(companyName_str);
        reffNumber_Handler.setText(refNumber_str);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void Cancel(View view) {
        finish();
    }

    public void Confirm(View view) {
        int fee= 100;
        if(fee<=50)
        {
            new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Sucessful..")
                    .setContentText("Successful Transition!")
                    .setConfirmText("OK")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            finish();
                        }
                    })
                    .show();

        }
        else {
            new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Transition Failed..")
                    .setContentText("Insufficient Current Balance")
                    .show();
        }

    }
}
