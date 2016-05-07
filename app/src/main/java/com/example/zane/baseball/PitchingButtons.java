package com.example.zane.baseball;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import org.json.JSONObject;

import java.util.HashMap;

public class PitchingButtons extends AppCompatActivity {
    int buttonVal = 0;
    static int pitchingButton = 0;
    static String pitchingJSONData = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButtonScreen.lastActivity = 2;
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        setContentView(R.layout.activity_pitching_buttons);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Wins_AT button pressed
        Button clickButton1 = (Button) findViewById(R.id.btnWin_AT);
        clickButton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonVal = 1;
                pitchingButton = 1;
                LongOperation op = new LongOperation();
                op.execute();
            }
        });
        //Wins_Season button pressed
        Button clickButton2 = (Button) findViewById(R.id.btnWin_Season);
        clickButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonVal = 2;
                pitchingButton = 2;
                LongOperation op = new LongOperation();
                op.execute();
            }
        });
        Button clickButton3 = (Button) findViewById(R.id.btnSO_AT);
        clickButton3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonVal = 3;
                pitchingButton = 3;
                LongOperation op = new LongOperation();
                op.execute();
            }
        });

        //Wins_Season button pressed
        Button clickButton4 = (Button) findViewById(R.id.btnSO_Season);
        clickButton4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonVal = 4;
                pitchingButton = 4;
                LongOperation op = new LongOperation();
                op.execute();
            }
        });
        Button clickButton5 = (Button) findViewById(R.id.btnER_AT);
        clickButton5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonVal = 5;
                pitchingButton = 5;
                LongOperation op = new LongOperation();
                op.execute();
            }
        });

        //Wins_Season button pressed
        Button clickButton6 = (Button) findViewById(R.id.btnERA_Season);
        clickButton6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonVal = 6;
                pitchingButton = 6;
                LongOperation op = new LongOperation();
                op.execute();
            }
        });
        Button clickButton7 = (Button) findViewById(R.id.btnzWar_Career);
        clickButton7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonVal = 7;
                pitchingButton = 7;
                LongOperation op = new LongOperation();
                op.execute();
            }
        });

        Button clickButton8 = (Button) findViewById(R.id.btnzWar_Season);
        clickButton8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonVal = 8;
                pitchingButton = 8;
                LongOperation op = new LongOperation();
                op.execute();
            }
        });
        Button clickButton9 = (Button) findViewById(R.id.btnWHIP_Career);
        clickButton9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonVal = 9;
                pitchingButton = 9;
                LongOperation op = new LongOperation();
                op.execute();
            }
        });

        Button clickButton10 = (Button) findViewById(R.id.btnWHIP_Season);
        clickButton10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonVal = 10;
                pitchingButton = 10;
                LongOperation op = new LongOperation();
                op.execute();
            }
        });
    }

    private class LongOperation extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... p) {
            HashMap<String, String> params = new HashMap<>();
            JSONParser parser = new JSONParser();
            JSONObject jObj = new JSONObject();
            switch (buttonVal) {
                //Wins Career Leader
                case 1:
                    jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/Win_Career.php", "GET", params);
                    String result1 = jObj.toString();
                    pitchingJSONData = result1;
                    break;
                //Wins Season Leader
                case 2:
                    jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/W_Season.php", "GET", params);
                    String result2 = jObj.toString();
                    pitchingJSONData = result2;
                    break;
                //SO Career
                case 3:
                    jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/SO_Career.php", "GET", params);
                    String result3 = jObj.toString();
                    pitchingJSONData = result3;
                    break;
                //Wins Season Leader
                case 4:
                    jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/SO_Season.php", "GET", params);
                    String result4 = jObj.toString();
                    pitchingJSONData = result4;
                    break;
                //ERA Career Leader
                case 5:
                    jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/ERA_Career.php", "GET", params);
                    String result5 = jObj.toString();
                    pitchingJSONData = result5;
                    break;
                //ERA Season Leader
                case 6:
                    jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/ERA_Season.php", "GET", params);
                    String result6 = jObj.toString();
                    pitchingJSONData = result6;
                    break;
                case 7:
                    jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/zWar_pitching.php", "GET", params);
                    String result7 = jObj.toString();
                    pitchingJSONData = result7;
                    break;
                //ERA Season Leader
                case 8:
                    jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/zWar_pitching_season.php", "GET", params);
                    String result8 = jObj.toString();
                    pitchingJSONData = result8;
                    break;
                case 9:
                    jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/WHIP_Career.php", "GET", params);
                    String result9 = jObj.toString();
                    pitchingJSONData = result9;
                    break;
                case 10:
                    jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/WHIP_Season.php", "GET", params);
                    String result10 = jObj.toString();
                    pitchingJSONData = result10;
                    break;
            }
            return "";
        }

        @Override
        protected void onPostExecute(String result) {
            Intent exSwitch = new Intent(PitchingButtons.this, DataDisplay.class);
            startActivity(exSwitch);
        }
//
//        @Override
//        protected String doInBackground(Void... params) {
//            return null;
//        }
//
//        @Override
//        protected void onPreExecute() {}
//
//        @Override
//        protected void onProgressUpdate(Void... values) {}
    }
}
