package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent intent = getIntent();
        TextView textView = findViewById(R.id.intentExtras);
        textView.setText(getString(R.string.activity_data,intent.getStringExtra("Name"),intent.getStringExtra("Address"),intent.getStringExtra("Postal Code")));
    }
}
