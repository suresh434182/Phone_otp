package com.example.otp_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.auth.PhoneAuthProvider;
import com.hbb20.CountryCodePicker;


public class Phone_Activity extends AppCompatActivity {
    EditText enternum;
    Button buttonsend;
    CountryCodePicker ccp;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_);
        mAuth = FirebaseAuth.getInstance();
        enternum = findViewById(R.id.etnumber1);
        buttonsend = findViewById(R.id.Getbutton);
        ccp = (CountryCodePicker) findViewById(R.id.ccp1);
        String PhoneNo=enternum.getText().toString();


        buttonsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (enternum.getText().toString().isEmpty()) {
                    Toast.makeText(Phone_Activity.this, "Phone number is required...", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent=new Intent(Phone_Activity.this,VerifyActivity.class);
                intent.putExtra("mobile",PhoneNo);
                startActivity(intent);
            }
        });
    }
}


