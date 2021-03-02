package com.example.b.pocket_wallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;

public class LoginActivity_pin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pin);


        Pinview pin = (Pinview) findViewById(R.id.pinview);
        pin.setInputType(Pinview.InputType.NUMBER);
        final TextView title = (TextView) findViewById(R.id.title);
        final TextView tv_reset_password = (TextView) findViewById(R.id.tv_reset_password);

        if (getIntent().getBooleanExtra("ChangeOPT", false)) {
            title.setText("Enter old 4 Digit OTP No:");
            tv_reset_password.setVisibility(View.INVISIBLE);

            pin.setPinViewEventListener(new Pinview.PinViewEventListener() {
                @Override
                public void onDataEntered(Pinview pinview, boolean fromUser) {
                    Toast.makeText(getApplicationContext(), "Enter New OTP", Toast.LENGTH_LONG).show();

                    startActivity(new Intent(getApplicationContext(), LoginActivity_pin.class));
                    finish();

                }
            });
        } else {

            pin.setPinViewEventListener(new Pinview.PinViewEventListener() {
                @Override
                public void onDataEntered(Pinview pinview, boolean fromUser) {

                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    finish();

                }
            });
        }
    }
}
