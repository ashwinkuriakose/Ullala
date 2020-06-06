package com.example.ullala;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    Button button;
    Button submit;
    EditText contact;
    String phNo;
    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        contact = (EditText) findViewById(R.id.phone_number_text);
        submit = (Button) findViewById(R.id.generate_btn);

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                phNo = contact.getText().toString();
                new CheckOwnMobileNumber().execute();
                Toast.makeText(getApplicationContext(), phNo, Toast.LENGTH_LONG).show();
            }
        });
       /* button=(Button)findViewById(R.id.generate_btn);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),otp.class);
                startActivity(i);
            }
        });*/
    }


    private class CheckOwnMobileNumber extends AsyncTask<String, Void, String> {
        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            if (progress.isShowing()) {
                progress.dismiss();

                // Check SMS Received or not after that open dialog date
                /*if(SMSReceiver.str.equals(phNo))
                {
                    Toast.makeText(getApplicationContext(), "Thanks for providing your number.", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Provide your own mobile number please.", Toast.LENGTH_LONG).show();
                    return;
                }*/

            }
        }

        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub
            String msg = phNo;
            try {
                sendSMS(phNo, msg);
            } catch (Exception ex) {
                Log.v("Exception :", "" + ex);
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            progress = ProgressDialog.show(login.this, "", "Checking Mobile Number...");
            progress.setIndeterminate(true);
            progress.getWindow().setLayout(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
            super.onPreExecute();
        }

        private void sendSMS(String phoneNumber, String message) {
            //PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, new Intent(getApplicationContext(), MainActivity.class), 0);
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(phoneNumber, null, message, null, null);

        }
    }
}