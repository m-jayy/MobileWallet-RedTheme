package com.example.b.pocket_wallet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {
    EditText Phone_Number;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Phone_Number=(EditText) findViewById(R.id.Phone_Number);


        TextView tv=(TextView) findViewById(R.id.next_btn);
        final TextView signup= (TextView) findViewById(R.id.signup);
        signup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),signupActivity.class));
                finish();

            }
        });

       // Button next_btn= (Button) findViewById(R.id.next_btn);
        tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                attemptLogin();
            }
        });


    }

    private void attemptLogin() {
        Phone_Number.setError(null);

        // Store values at the time of the login attempt.
        String ph_no = Phone_Number.getText().toString();
        boolean cancel = false;
        View focusView = null;
        // Check for a valid password, if the user entered one.

        // Check for a valid email address.
        if (TextUtils.isEmpty(ph_no)) {
            Phone_Number.setError(getString(R.string.error_field_required));
            focusView = Phone_Number;
            cancel = true;
        } else if (!isEmailValid(ph_no)) {
            Phone_Number.setError("This CNIC is invalid");
            focusView = Phone_Number;
            cancel = true;

        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        }
        else{
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(),LoginActivity_pin.class));
                    finish();
                }
            }, 3000);
        }






    }
    private boolean isEmailValid(String ph_no) {
        //TODO: Replace this with your own logic
        return ph_no.length()==13;
    }

}

