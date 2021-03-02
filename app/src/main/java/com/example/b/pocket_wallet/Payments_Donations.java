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

public class Payments_Donations extends AppCompatActivity {
    Button pay_Handler;
    EditText amount_Handler;
    TextView companyName_Handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments_donations);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Payments");
        setSupportActionBar(toolbar);
                getSupportActionBar().setHomeButtonEnabled(true);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pay_Handler = (Button) findViewById(R.id.pay);
        amount_Handler = (EditText) findViewById(R.id.amount);
        companyName_Handler= (TextView) findViewById(R.id.companyName);

        companyName_Handler.setText(getIntent().getStringExtra("CompanyName"));

        pay_Handler.setOnClickListener(new View.OnClickListener() {
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
        amount_Handler.setError(null);


        String var_amount = amount_Handler.getText().toString();

        boolean cancel = false;
        View focusView = null;

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

           // String[] data = new String[] { companyName_Handler.getText().toString(),amount_Handler.getText().toString(), "Two", "Three" };
            Intent intent = new Intent(getApplicationContext(),Payments_Donations_Confirmation.class);
            intent.putExtra("amount",amount_Handler.getText().toString());
            intent.putExtra("companyName",companyName_Handler.getText().toString());
            startActivity(intent);
        }
    }
}
