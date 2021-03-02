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

public class Payments_AmountTransfer extends AppCompatActivity {

    Button transfer_btn;
    EditText mPhoneNum_Handler,amount_Handler,cninc_Handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments_amounttransfer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Payments");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        transfer_btn = (Button) findViewById(R.id.transfer);
        mPhoneNum_Handler = (EditText) findViewById(R.id.Phone_Number);
        amount_Handler= (EditText) findViewById(R.id.amount);
        cninc_Handler= (EditText) findViewById(R.id.cnic);



        transfer_btn.setOnClickListener(new View.OnClickListener() {
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
        mPhoneNum_Handler.setError(null);
        amount_Handler.setError(null);
        cninc_Handler.setError(null);


        String var_cninc = cninc_Handler.getText().toString();
        String var_mPhoneNum = mPhoneNum_Handler.getText().toString();
        String var_amount = amount_Handler.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(var_cninc))
        {
            cninc_Handler.setError(getString(R.string.error_field_required));
            focusView = cninc_Handler;
            cancel = true;
        }
        else if (!isCNICValid(var_cninc))
        {
            cninc_Handler.setError("This CNIC is invalid");
            focusView = cninc_Handler;
            cancel = true;
        }
        if (TextUtils.isEmpty(var_mPhoneNum))
        {
            mPhoneNum_Handler.setError(getString(R.string.error_field_required));
            focusView = mPhoneNum_Handler;
            cancel = true;
        }
        else if(!isPhoneNumValid(var_mPhoneNum))
        {
            mPhoneNum_Handler.setError("This Phone Number is invalid");
            focusView = mPhoneNum_Handler;
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
            Intent intent = new Intent(getApplicationContext(),Payments_AmountTransfer_Confirmation.class);
            intent.putExtra("cninc",cninc_Handler.getText().toString());
            intent.putExtra("mPhoneNum",mPhoneNum_Handler.getText().toString());
            intent.putExtra("amount",amount_Handler.getText().toString());
            startActivity(intent);
        }
    }

    private boolean isCNICValid(String CNIC) {

        return CNIC.length()==13;
    }
    private boolean isPhoneNumValid(String CNIC) {

        return CNIC.length()==11;
    }
}
