package com.example.b.pocket_wallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class BillPayments_MobileTopups_Company extends AppCompatActivity {

    Button Transfer_Handler;
    EditText receiverNumber_Handler;
    EditText amount_Handler;
    TextView ComapnyName_Handler;
    String var_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billpayments__mobiletopups_company);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Mobile Topusp");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Transfer_Handler = (Button) findViewById(R.id.transfer);
        receiverNumber_Handler = (EditText) findViewById(R.id.receiverNumber);
        amount_Handler = (EditText) findViewById(R.id.amount);
        ComapnyName_Handler= (TextView) findViewById(R.id.ComapnyName);

        ComapnyName_Handler.setText(getIntent().getStringExtra("CompanyName"));

        Transfer_Handler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptNextPage();
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
    private void attemptNextPage() {
        receiverNumber_Handler.setError(null);
        amount_Handler.setError(null);


        String var_receiverNumber = receiverNumber_Handler.getText().toString();
        var_amount = amount_Handler.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(var_receiverNumber))
        {
            receiverNumber_Handler.setError(getString(R.string.error_field_required));
            focusView = receiverNumber_Handler;
            cancel = true;
        }
        else if (!isPhValid(var_receiverNumber)) {
            receiverNumber_Handler.setError("This Phone Number is invalid");
            focusView = receiverNumber_Handler;
            cancel = true;
        }
        if (TextUtils.isEmpty(var_amount))
        {
            amount_Handler.setError(getString(R.string.error_field_required));
            focusView = amount_Handler;
            cancel = true;
        }


        if (cancel)
        {
            focusView.requestFocus();
        }
        else
        {
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Confirmation")
                    .setContentText("Are you sure? you want to transfer Money")
                    .setConfirmText("Yes")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismissWithAnimation();

                            int fee= Integer.parseInt(var_amount);
                            if(fee<=50)
                            {
                                new SweetAlertDialog(BillPayments_MobileTopups_Company.this, SweetAlertDialog.SUCCESS_TYPE)
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
                                new SweetAlertDialog(BillPayments_MobileTopups_Company.this, SweetAlertDialog.ERROR_TYPE)
                                        .setTitleText("Transition Failed..")
                                        .setContentText("Insufficient Current Balance")
                                        .show();
                            }
                        }
                    })
                    .show();
        }
    }

    private boolean isPhValid(String PH) {
        //TODO: Replace this with your own logic
        return PH.length()==11;
    }
}
