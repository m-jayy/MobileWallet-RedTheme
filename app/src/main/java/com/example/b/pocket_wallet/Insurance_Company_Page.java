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

public class Insurance_Company_Page extends AppCompatActivity {
    Button next_btn;
    EditText Policy_Handler;
    TextView CompanyName_Handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance__company__page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Insurance");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        next_btn = (Button) findViewById(R.id.next);
        Policy_Handler = (EditText) findViewById(R.id.policyNumber);
        CompanyName_Handler= (TextView) findViewById(R.id.companyName);

        CompanyName_Handler.setText(getIntent().getStringExtra("IncuranceCompany"));

        next_btn.setOnClickListener(new View.OnClickListener() {
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
        Policy_Handler.setError(null);


        String var_Policy = Policy_Handler.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(var_Policy))
        {
            Policy_Handler.setError(getString(R.string.error_field_required));
            focusView = Policy_Handler;
            cancel = true;
        }

        if (cancel)
        {
            focusView.requestFocus();
        }
        else
        {
            Intent intent = new Intent(getApplicationContext(),Insurance_Confirmation_Page.class);
            intent.putExtra("IncuranceCompany",CompanyName_Handler.getText().toString());
            intent.putExtra("PolicyID",Policy_Handler.getText().toString());
            startActivity(intent);
        }
    }
}
