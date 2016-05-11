package com.example.zane.baseball;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class SearchButton extends AppCompatActivity {
    static String result = "";
    static int notFound =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        ButtonScreen.lastActivity = 3;



        JSONObject jObj = new JSONObject();
        try {
            jObj.put("firstName", ButtonScreen.firstName);
            jObj.put("lastName", ButtonScreen.lastName);
            LongOperation httpNameRelay = new LongOperation();
            httpNameRelay.execute(jObj.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
    private class LongOperation extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            JSONParser parser = new JSONParser();
            String http = "";
            if(ButtonScreen.noName==true)
            {
                ButtonScreen.noName = false;
            }
            else
            {
                if(ButtonScreen.batterSearch == 1)
                {
                    http = "http://slippyslappy.atwebpages.com/Batter_Search.php?";
                }
                else if(ButtonScreen.pitcherSearch ==1)
                {
                    http = "http://slippyslappy.atwebpages.com/Pitcher_Search.php?";
                }
                http += "firstName=" + ButtonScreen.firstName + "&lastName=" + ButtonScreen.lastName;
                HashMap<String, String> aa = new HashMap<>();
                JSONObject object= parser.makeHttpRequest(http,"GET",aa);
                if(object == null)
                {
                    System.out.println("PlayerNotFound");
                    notFound =1;
                }
                else
                {
                    notFound = 0;
                    result = object.toString();
                }
            }
            System.out.println(result);
            return "";
        }
        @Override
        protected void onPostExecute(String a) {
            Intent exSwitch = new Intent(SearchButton.this, DataDisplay.class);
            startActivity(exSwitch);
        }
    }
}
