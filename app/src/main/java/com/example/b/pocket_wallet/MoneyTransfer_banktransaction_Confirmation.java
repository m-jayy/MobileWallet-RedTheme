package com.example.b.pocket_wallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MoneyTransfer_banktransaction_Confirmation extends AppCompatActivity {

    String BankName_str, AccountNumber_str,Amount_str;
    TextView BankName_Handler, AccountNumber_Handler,Amount_Handler,TotalAmount_Handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moneytransfer_banktransaction_confirmation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Bank Funds Transfer");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BankName_str = getIntent().getStringExtra("BankName");
        AccountNumber_str = getIntent().getStringExtra("accNum");
        Amount_str = getIntent().getStringExtra("amount");

        BankName_Handler = (TextView) findViewById(R.id.BankName);
        AccountNumber_Handler = (TextView) findViewById(R.id.accNum);
        Amount_Handler = (TextView) findViewById(R.id.Amount);
        TotalAmount_Handler = (TextView) findViewById(R.id.total);



        BankName_Handler.setText(BankName_str);
        AccountNumber_Handler.setText(AccountNumber_str);
        Amount_Handler.setText("RS. "+Amount_str);
        TotalAmount_Handler.setText("RS. "+Amount_str);
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
        int fee= Integer.parseInt(Amount_str);
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
