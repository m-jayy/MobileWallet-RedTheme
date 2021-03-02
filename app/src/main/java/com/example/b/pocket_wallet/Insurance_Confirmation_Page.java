package com.example.b.pocket_wallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Insurance_Confirmation_Page extends AppCompatActivity {

    String companyName_str, PolicyNumber_str;
    TextView companyName_Handler, PolicyNumber_Handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance__confirmation__page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Insurance");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        companyName_str = getIntent().getStringExtra("IncuranceCompany");
        PolicyNumber_str = getIntent().getStringExtra("PolicyID");

        companyName_Handler = (TextView) findViewById(R.id.ComapnyName);
        PolicyNumber_Handler = (TextView) findViewById(R.id.PolicyID);


        companyName_Handler.setText(companyName_str);
        PolicyNumber_Handler.setText(PolicyNumber_str);
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
