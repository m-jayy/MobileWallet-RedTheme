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

public class BillPayments_Utilities_Telephone extends AppCompatActivity {

    Button Getbill_Handler;
    EditText refNum_Handler;
    TextView ComapnyName_Handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billpayments__utilities__telephone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Bill Payments");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Getbill_Handler = (Button) findViewById(R.id.getBill);
        refNum_Handler = (EditText) findViewById(R.id.RefferenceNum);
        ComapnyName_Handler= (TextView) findViewById(R.id.ComapnyName);

        ComapnyName_Handler.setText(getIntent().getStringExtra("CompanyName"));

        Getbill_Handler.setOnClickListener(new View.OnClickListener() {
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
        refNum_Handler.setError(null);


        String var_ID = refNum_Handler.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(var_ID))
        {
            refNum_Handler.setError(getString(R.string.error_field_required));
            focusView = refNum_Handler;
            cancel = true;
        }

        if (cancel)
        {
            focusView.requestFocus();
        }
        else
        {
            Intent intent = new Intent(getApplicationContext(),BillPayments_Utilities_Telephone_Conformation.class);
            intent.putExtra("AccountID",refNum_Handler.getText().toString());
            intent.putExtra("ComapnyName",ComapnyName_Handler.getText().toString());
            startActivity(intent);
        }
    }
}
