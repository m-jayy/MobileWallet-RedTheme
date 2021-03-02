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

public class Payments_FeeCollection extends AppCompatActivity {
    Button pay_Handler;
    EditText studentID_Handler;
    TextView schoolName_Handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments_feecollection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Payments");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pay_Handler = (Button) findViewById(R.id.pay);
        studentID_Handler = (EditText) findViewById(R.id.studnetID);
        schoolName_Handler= (TextView) findViewById(R.id.schoolName);

        schoolName_Handler.setText(getIntent().getStringExtra("SchoolName"));

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
        studentID_Handler.setError(null);


        String var_ID = studentID_Handler.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(var_ID))
        {
            studentID_Handler.setError(getString(R.string.error_field_required));
            focusView = studentID_Handler;
            cancel = true;
        }

        if (cancel)
        {
            focusView.requestFocus();
        }
        else
        {
            Intent intent = new Intent(getApplicationContext(),Payments_FeeCollection_Confirmation.class);
            intent.putExtra("studentID",studentID_Handler.getText().toString());
            intent.putExtra("schoolName",schoolName_Handler.getText().toString());
            startActivity(intent);
        }
    }
}
