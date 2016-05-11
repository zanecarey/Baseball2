package com.example.zane.baseball;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class ButtonScreen extends AppCompatActivity {
    static int lastActivity = 0;
    static String firstName = "";
    static String lastName = "";
    static int batterSearch = 0;
    static int pitcherSearch = 0;
    static boolean noName = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_button_screen);
        Button clickButton1 = (Button) findViewById(R.id.searchBatter_button);
        clickButton1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ButtonScreen.this);
                builder.setTitle("Enter Player Name: (First Last)");

                // Set up the input
                final EditText input = new EditText(ButtonScreen.this);
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
                builder.setView(input);

                // Set up the buttons
                builder.setPositiveButton("Search", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = "";
                        name = input.getText().toString();
                        if (name.length() == 0) {
                            noName = true;
                            SearchButton.notFound = 1;
                        } else {
                            String[] nameArray = name.split(" ");
                            firstName = nameArray[0];
                            lastName = nameArray[1];
                            batterSearch = 1;
                            Intent exSwitch = new Intent(ButtonScreen.this, SearchButton.class);
                            startActivity(exSwitch);
                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });


        Button clickButton2 = (Button) findViewById(R.id.searchPitcher_button);
        clickButton2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ButtonScreen.this);
                builder.setTitle("Enter Player Name:(First Last)");

                // Set up the input
                final EditText input = new EditText(ButtonScreen.this);
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
                builder.setView(input);

                // Set up the buttons
                builder.setPositiveButton("Search", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = "";
                        name = input.getText().toString();
                        if (name.length() == 0) {
                            noName = true;
                            SearchButton.notFound = 1;
                        }
                        else
                        {
                            String[] nameArray = name.split(" ");
                            firstName = nameArray[0];
                            lastName = nameArray[1];
                            pitcherSearch = 1;
                            Intent exSwitch = new Intent(ButtonScreen.this, SearchButton.class);
                            startActivity(exSwitch);
                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();


            }
        });



        Button clickButton3 = (Button) findViewById(R.id.batting_button);
        clickButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exSwitch = new Intent(ButtonScreen.this, OffensiveButtons.class);
                startActivity(exSwitch);

            }
        });


        Button clickButton4 = (Button) findViewById(R.id.pitching_button);
        clickButton4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent exSwitch = new Intent(ButtonScreen.this, PitchingButtons.class);
                startActivity(exSwitch);
            }
        });
    }
}
