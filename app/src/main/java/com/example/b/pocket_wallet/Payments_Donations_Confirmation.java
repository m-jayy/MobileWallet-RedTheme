package com.example.b.pocket_wallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Payments_Donations_Confirmation extends AppCompatActivity {
    String CompanyName, amount_str;
    TextView companyName_Handler, amount_Handler, Total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments_donations__confirmation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Payments");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CompanyName = getIntent().getStringExtra("companyName");
        amount_str = getIntent().getStringExtra("amount");

        companyName_Handler = (TextView) findViewById(R.id.companyName);
        amount_Handler = (TextView) findViewById(R.id.amount);
        Total = (TextView) findViewById(R.id.total);

        companyName_Handler.setText(CompanyName);
        amount_Handler.setText("RS. "+amount_str);
        Total.setText("RS. "+amount_str);
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
        int amount=Integer.parseInt(amount_str);
        if(amount<=50)
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
