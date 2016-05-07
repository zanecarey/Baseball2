package com.example.zane.baseball;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.json.JSONObject;

import java.util.HashMap;

public class OffensiveButtons extends AppCompatActivity {


    int buttonVal = 0;
    static int hittingButton = 0;
    static String offensiveJSONData = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offensive_buttons);

        ButtonScreen.lastActivity = 1;
        //HR_AT button pressed
        Button clickButton1 = (Button) findViewById(R.id.btnHR_AT);
        clickButton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonVal = 1;
                hittingButton = 1;
                LongOperation thing = new LongOperation();
                thing.execute();
            }
        });


        //HR_Season button pressed
        Button clickButton2 = (Button) findViewById(R.id.btnHR_Season);
        clickButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonVal = 2;
                hittingButton = 2;
                LongOperation thing = new LongOperation();
                thing.execute();

            }
        });
        //RBI AT button pressed
        Button clickButton3 = (Button) findViewById(R.id.btnRBI_AT);
        clickButton3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonVal = 3;
                hittingButton = 3;
                LongOperation thing = new LongOperation();
                thing.execute();
            }
        });


        //RBI S button pressed
        Button clickButton4 = (Button) findViewById(R.id.btnRBI_Season);
        clickButton4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonVal = 4;
                hittingButton = 4;
                LongOperation thing = new LongOperation();
                thing.execute();

            }
        });

        //SB AT button pressed
        Button clickButton5 = (Button) findViewById(R.id.btnSB_AT);
        clickButton5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonVal = 5;
                hittingButton = 5;
                LongOperation thing = new LongOperation();
                thing.execute();
            }
        });


        //SB S button pressed
        Button clickButton6 = (Button) findViewById(R.id.btnSB_Season);
        clickButton6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonVal = 6;
                hittingButton = 6;
                LongOperation thing = new LongOperation();
                thing.execute();

            }
        });
        //AVG C button pressed
        Button clickButton7 = (Button) findViewById(R.id.btnAVG_Career);
        clickButton7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonVal = 7;
                hittingButton = 7;
                LongOperation thing = new LongOperation();
                thing.execute();

            }
        });
        //AVG C button pressed
        Button clickButton8 = (Button) findViewById(R.id.btnAVG_Season);
        clickButton8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonVal = 8;
                hittingButton = 8;
                LongOperation thing = new LongOperation();
                thing.execute();

            }
        });
        Button clickButton9 = (Button) findViewById(R.id.btnzWar_Career);
        clickButton9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonVal = 9;
                hittingButton = 9;
                LongOperation thing = new LongOperation();
                thing.execute();

            }
        });
        //AVG C button pressed
        Button clickButton10 = (Button) findViewById(R.id.btnzWar_Season);
        clickButton10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonVal = 10;
                hittingButton = 10;
                LongOperation thing = new LongOperation();
                thing.execute();

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
                //Home run Career Leaders
                case 1:
                    jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/HR_Career_Leaders.php", "GET", params);
                    String result1 = jObj.toString();
                    offensiveJSONData = result1;
                    //TextView text = (TextView) findViewById(R.id.);
                    break;
                //Home run season leaders
                case 2:
                    jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/HR_Season_Leaders.php", "GET", params);
                    String result2 = jObj.toString();
                    offensiveJSONData = result2;
                    break;
                //RBI LEADER ALL TIME
                case 3:
                    jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/RBI_Career.php", "GET", params);
                    String result3 = jObj.toString();
                    offensiveJSONData = result3;
                    break;
                //RBI Season Leader
                case 4:
                    jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/RBI_Season.php", "GET", params);
                    String result4 = jObj.toString();
                    offensiveJSONData = result4;
                    break;
                case 5:
                    jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/SB_Career.php", "GET", params);
                    String result5 = jObj.toString();
                    offensiveJSONData = result5;
                    break;
                case 6:
                    jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/SB_Season.php", "GET", params);
                    String result6 = jObj.toString();
                    offensiveJSONData = result6;
                    break;
                case 7:
                    jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/AVG_Career.php", "GET", params);
                    String result7 = jObj.toString();
                    offensiveJSONData = result7;
                    break;
                case 8:
                    jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/AVG_Season.php", "GET", params);
                    String result8 = jObj.toString();
                    offensiveJSONData = result8;
                    break;
                case 9:
                    jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/zWar_Career.php", "GET", params);
                    String result9 = jObj.toString();
                    offensiveJSONData = result9;
                    break;
                case 10:
                    jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/zWar_Season.php", "GET", params);
                    String result10 = jObj.toString();
                    offensiveJSONData = result10;
                    break;
            }
            return "";
        }

        @Override
        protected void onPostExecute(String result) {
            Intent exSwitch = new Intent(OffensiveButtons.this, DataDisplay.class);
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
