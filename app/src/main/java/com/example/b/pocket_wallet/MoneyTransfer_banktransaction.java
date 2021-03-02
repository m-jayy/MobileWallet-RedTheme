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

public class MoneyTransfer_banktransaction extends AppCompatActivity {

    Button Transfer_Handler;
    TextView BankName_Handler;
    EditText accNum_Handler;
    EditText amount_Handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moneytransfer_banktransaction);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Money Transfer");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Transfer_Handler = (Button) findViewById(R.id.transfer);
        BankName_Handler= (TextView) findViewById(R.id.BankName);
        accNum_Handler = (EditText) findViewById(R.id.accNumber);
        amount_Handler = (EditText) findViewById(R.id.amount);


        BankName_Handler.setText(getIntent().getStringExtra("BankName"));

        accNum_Handler.setSelection(accNum_Handler.getText().length());

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
        accNum_Handler.setError(null);
        amount_Handler.setError(null);


        String var_accNum = accNum_Handler.getText().toString();
        String var_amount = amount_Handler.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(var_accNum))
        {
            accNum_Handler.setError(getString(R.string.error_field_required));
            focusView = accNum_Handler;
            cancel = true;
        }
        else if(!accountIsValid(var_accNum))
        {
            accNum_Handler.setError("Invalid Account Number");
            focusView = accNum_Handler;
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
            Intent intent = new Intent(getApplicationContext(),MoneyTransfer_banktransaction_Confirmation.class);
            intent.putExtra("BankName",BankName_Handler.getText().toString());
            intent.putExtra("accNum",accNum_Handler.getText().toString());
            intent.putExtra("amount",amount_Handler.getText().toString());
            startActivity(intent);
        }
    }

    private boolean accountIsValid(String var_accNum) {
        return var_accNum.length()==13;
    }
}
