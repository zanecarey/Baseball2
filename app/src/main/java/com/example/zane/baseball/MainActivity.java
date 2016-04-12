package com.example.zane.baseball;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import android.widget.ListView;
import android.util.Log;

public class MainActivity extends Activity {

    JSONObject obj = null;
    String myJSON;
    int buttonVal = 0;

    JSONArray peoples = null;

    ArrayList<HashMap<String, String>> personList;
    HashMap<String,String> params = new HashMap<>();
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //HR_AT button pressed
        Button clickButton1 = (Button) findViewById(R.id.btnHR_AT);
        clickButton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

//                //HashMap<String, String> params = new HashMap<>();
//                params.put("playerID", "");
//                params.put("HR Total", "");
//                JSONParser parser = new JSONParser();
//                JSONObject jObj = new JSONObject();
//                jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/HR_Career_Leaders.php", "GET", params);
//                String result = jObj.toString();
//                System.out.println(result);
                buttonVal = 1;
                LongOperation thing = new LongOperation();
                thing.execute();

            }
        });


        //HR_Season button pressed
        Button clickButton2 = (Button) findViewById(R.id.btnHR_Season);
        clickButton2.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

//                HashMap<String, String> params = new HashMap<>();
//                params.put("playerID", "");
//                params.put("HR Total", null);
//                JSONParser parser = new JSONParser();
//                JSONObject jObj = new JSONObject();
//                jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/HR_Season.php", "GET", params);
                buttonVal = 2;
                LongOperation thing = new LongOperation();
                thing.execute();

            }
        });


        //Wins_AT button pressed
        Button clickButton3 = (Button) findViewById(R.id.btnWin_AT);
        clickButton3.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                HashMap<String, String> params = new HashMap<>();
                params.put("playerID", "");
                params.put("HR Total", null);
                JSONParser parser = new JSONParser();
                JSONObject jObj = new JSONObject();
                jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/HR_Season_Leaders.php", "GET", params);
                String result = jObj.toString();

            }
        });
    }


    private class LongOperation extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... p) {
            HashMap<String, String> params = new HashMap<>();
            JSONParser parser = new JSONParser();
            JSONObject jObj = new JSONObject();
            switch(buttonVal) {
                //Home run Career Leaders
                case 1:
                    params.put("playerID", "");
                    params.put("HR Total", "");
                    jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/HR_Career_Leaders.php", "GET", params);
                    String result1 = jObj.toString();
                    System.out.println(result1);
                    break;
                //Home run season leaders
                case 2:
                    params.put("playerID", "");
                    params.put("HR Total", "");

                    jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/HR_Season.php", "GET", params);
                    String result2 = jObj.toString();
                    System.out.println(result2);
                    break;
                //Wins Career Leader
                case 3:



            }


            return "";
        }

//        @Override
//        protected void onPostExecute(String result) {
//
//        }
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


