package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

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


        Spinner spinner = findViewById(R.id.planets_spinner);
        spinner.setOnItemSelectedListener(this);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
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

    public void startNewActivityWithIntent(View view) {
        EditText name =  findViewById(R.id.secondEditText);
        EditText address = findViewById(R.id.thirdEditText);
        EditText postcode = findViewById(R.id.fourthEditText);

        Intent startNewActivity = new Intent(MainActivity.this, NewActivity.class);
        Bundle extras = new Bundle();
        extras.putString("Name", name.getText().toString());
        extras.putString("Address", address.getText().toString());
        extras.putString("Postal Code", postcode.getText().toString());
        startNewActivity.putExtras(extras);
        MainActivity.this.startActivity(startNewActivity);
    }

    public void openBrowserWithIntent(View view) {
        String url = "http://www.google.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        MainActivity.this.startActivity(i);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,parent.getItemAtPosition(position).toString() +" selected", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
