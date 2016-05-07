package com.example.zane.baseball;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends Activity {

    JSONObject obj = null;
    String myJSON;
    int buttonVal = 0;
    static String jsonData = "";


    JSONArray peoples = null;

    ArrayList<HashMap<String, String>> personList;
    HashMap<String, String> params = new HashMap<>();
    ListView list;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SearchButton
//        Button clickButtonSearch = (Button) findViewById(R.id.btnPlayer_Search);
//        clickButtonSearch.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                buttonVal = 5;
//                LongOperation thing = new LongOperation();
//                thing.execute();
//            }
//        });




//        //Wins_AT button pressed
//        Button clickButton3 = (Button) findViewById(R.id.btnWin_AT);
//        clickButton3.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                buttonVal = 3;
//                LongOperation op = new LongOperation();
//                op.execute();
//            }
//        });
//
//        //Wins_Season button pressed
//        Button clickButton4 = (Button) findViewById(R.id.btnWin_Season);
//        clickButton4.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                buttonVal = 4;
//                LongOperation op = new LongOperation();
//                op.execute();
//            }
//        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.zane.baseball/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.zane.baseball/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
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
                    params.put("playerID", "");
                    params.put("HR Total", "");
                    jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/HR_Career_Leaders.php", "GET", params);
                    String result1 = jObj.toString();
                    System.out.println(result1);
                    jsonData = result1;
                    //TextView text = (TextView) findViewById(R.id.);
                    break;
                //Home run season leaders
                case 2:
                    params.put("playerID", "");
                    params.put("HR Total", "");
                    jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/HR_Season.php", "GET", params);
                    String result2 = jObj.toString();
                    System.out.println(result2);
                    jsonData = result2;
                    break;
                //Wins Career Leader
                case 3:
                    params.put("playerID", "");
                    params.put("HR Total", "");
                    jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/W_Career.php", "GET", params);
                    String result3 = jObj.toString();
                    System.out.println(result3);
                    jsonData = result3;
                    break;
                //Wins Season Leader
                case 4:
                    params.put("playerID", "");
                    params.put("HR Total", "");
                    jObj = parser.makeHttpRequest("http://slippyslappy.atwebpages.com/W_Season.php", "GET", params);
                    String result4 = jObj.toString();
                    System.out.println(result4);
                    jsonData = result4;
                    break;




            }


            return "";
        }

        @Override
        protected void onPostExecute(String result) {
            Intent exSwitch = new Intent(MainActivity.this, DataDisplay.class);
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


