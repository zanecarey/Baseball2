package com.example.zane.baseball;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ButtonScreen extends AppCompatActivity {
    static int lastActivity = 0;
    private String playerName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_screen);

        Button clickButton1 = (Button) findViewById(R.id.search_button);
        clickButton1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ButtonScreen.this);
                builder.setTitle("Title");

                // Set up the input
                final EditText input = new EditText(ButtonScreen.this);
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
                builder.setView(input);

                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        playerName = input.getText().toString();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();

                Intent exSwitch = new Intent(ButtonScreen.this, SearchButton.class);
                startActivity(exSwitch);
            }
        });


        Button clickButton2 = (Button) findViewById(R.id.batting_button);
        clickButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exSwitch = new Intent(ButtonScreen.this, OffensiveButtons.class);
                startActivity(exSwitch);

            }
        });


        Button clickButton3 = (Button) findViewById(R.id.pitching_button);
        clickButton3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent exSwitch = new Intent(ButtonScreen.this, PitchingButtons.class);
                startActivity(exSwitch);
            }
        });
    }
}
