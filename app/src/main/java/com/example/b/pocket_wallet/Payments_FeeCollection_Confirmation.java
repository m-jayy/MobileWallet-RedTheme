package com.example.b.pocket_wallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Payments_FeeCollection_Confirmation extends AppCompatActivity {

    String SchoolName_str, studentID_str;
    TextView schoolName_Handler, studentID_Handler,fee_Handler, Total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments_feecollection_confirmation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Payments");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SchoolName_str = getIntent().getStringExtra("schoolName");
        studentID_str = getIntent().getStringExtra("studentID");

        schoolName_Handler = (TextView) findViewById(R.id.schoolName);
        studentID_Handler = (TextView) findViewById(R.id.StudentID);
        fee_Handler = (TextView) findViewById(R.id.fee);
        Total = (TextView) findViewById(R.id.total);

        schoolName_Handler.setText(SchoolName_str);
        studentID_Handler.setText("RS. "+studentID_str);
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
