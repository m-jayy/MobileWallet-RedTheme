package com.example.b.pocket_wallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Payments_AmountTransfer_Confirmation extends AppCompatActivity {

    String cnic_str, mobileNum_str,Amount_str;
    TextView cnic_Handler, mobileNum_Handler,Amount_Handler, Total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments_amounttransfer_confirmation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Payments");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mobileNum_str = getIntent().getStringExtra("mPhoneNum");
        cnic_str = getIntent().getStringExtra("cninc");
        Amount_str = getIntent().getStringExtra("amount");

        cnic_Handler = (TextView) findViewById(R.id.cnic);
        mobileNum_Handler = (TextView) findViewById(R.id.mobileNumber);
        Amount_Handler = (TextView) findViewById(R.id.amount);
        Total = (TextView) findViewById(R.id.total);

        cnic_Handler.setText(cnic_str);
        mobileNum_Handler.setText(mobileNum_str);
        Amount_Handler.setText("RS. "+Amount_str);
        Total.setText("RS. "+Amount_str);
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
        int amt = Integer.parseInt(Amount_str);

        if(amt<=50)
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
