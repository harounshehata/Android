package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.thirdButton);

        button.setOnLongClickListener((view) -> {
            Toast.makeText(this,"This is a long click!",Toast.LENGTH_LONG).show();
            return true;
        });

        button.setOnClickListener((view) -> {EditText editText = findViewById(R.id.secondEditText);
            editText.setText("This is a single click!");});

    }

    /** Called when the user taps the Send button */
    public void sendMessageGerman(View view) {
        EditText editText = findViewById(R.id.firstEditText);
        editText.setText("Nachricht eingeben!");
    }

    public void sendMessageEnglish(View view) {
        EditText editText = findViewById(R.id.firstEditText);
        editText.setText("Enter a message!");
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event)
    {
        switch (keyCode){
            default:
                if(event.isShiftPressed())
                {
                    Toast.makeText(this, String.format("You have clicked SHIFT + %s", (char) event.getUnicodeChar()), Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(this, String.format("You have clicked %s", (char) event.getUnicodeChar()), Toast.LENGTH_LONG).show();
                }
                break;
        }
        return super.onKeyDown(keyCode, event);
    }
}
