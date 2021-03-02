package com.example.b.pocket_wallet;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class signupActivity extends AppCompatActivity {
    EditText Phone_Number_Handler,cnic_handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Phone_Number_Handler =(EditText) findViewById(R.id.Phone_Number);
        cnic_handler = (EditText) findViewById(R.id.cnic);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();

            }
        });
    }

    private void attemptLogin() {
        Phone_Number_Handler.setError(null);
        cnic_handler.setError(null);
        // Store values at the time of the login attempt.
        String var_ph = Phone_Number_Handler.getText().toString();
        String var_cnic = cnic_handler.getText().toString();
        boolean cancel = false;
        View focusView = null;
        // Check for a valid password, if the user entered one.

        // Check for a valid email address.
        if (TextUtils.isEmpty(var_ph)) {
            Phone_Number_Handler.setError(getString(R.string.error_field_required));
            focusView = Phone_Number_Handler;
            cancel = true;
        } else if (!isPhValid(var_ph)) {
            Phone_Number_Handler.setError("This Phone Number is invalid");
            focusView = Phone_Number_Handler;
            cancel = true;
        }

        if (TextUtils.isEmpty(var_cnic)) {
            cnic_handler.setError(getString(R.string.error_field_required));
            focusView = cnic_handler;
            cancel = true;
        } else if (!isCNICValid(var_cnic)) {
            cnic_handler.setError("This CNIC is invalid");
            focusView = cnic_handler;
            cancel = true;
        }


        if (cancel) {

            focusView.requestFocus();

        } else {////////////// if all set than start actual work after click listner
            startActivity(new Intent(getApplicationContext(),LoginActivity_pin.class));
            finish();
        }
    }
    private boolean isCNICValid(String CNIC) {
        //TODO: Replace this with your own logic
        return CNIC.length()==13;
    }
    private boolean isPhValid(String PH) {
        //TODO: Replace this with your own logic
        return PH.length()==11;
    }
}
