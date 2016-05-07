package com.example.zane.baseball;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataDisplay extends AppCompatActivity {
    JSONObject theString = null;
    static final int BATTING = 1;
    static final int PITCHING = 2;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        TextView textview = (TextView) findViewById(R.id.textView1);
        textview.setMovementMethod(new ScrollingMovementMethod());//enable scrolling

        try {
            if(ButtonScreen.lastActivity == 1)//Came from OffensiveButton
            {
                if(OffensiveButtons.hittingButton == 1)//HR ALL TIME
                {
                    textview.setText("Homerun Leaders: All Time");
                    tvAppend(textview, BATTING, 1);
                }
                else if(OffensiveButtons.hittingButton == 2)//HR SINGLE SEASON
                {
                    textview.setText("Homerun Leaders: Single Season");
                    tvAppend(textview, BATTING, 2);
                }
                else if(OffensiveButtons.hittingButton == 3)//RBI ALL TIME
                {
                    textview.setText("RBI Leaders: All Time");
                    tvAppend(textview, BATTING, 1);
                }
                else if(OffensiveButtons.hittingButton == 4)//RBI SEASON
                {
                    textview.setText("RBI Leaders: Single Season");
                    tvAppend(textview, BATTING, 2);
                }
                else if(OffensiveButtons.hittingButton == 5)//SB AT
                {
                    textview.setText("Stolen Base Leaders: All Time");
                    tvAppend(textview, BATTING, 1);
                }
                else if(OffensiveButtons.hittingButton == 6)//SB Season
                {
                    textview.setText("Stolen Base Leaders: Single Season");
                    tvAppend(textview, BATTING, 2);
                }
                else if(OffensiveButtons.hittingButton == 7)//AVG AT
                {
                    textview.setText("Batting Average Leaders: All Time");
                    tvAppend(textview, BATTING, 1);
                }
                else if(OffensiveButtons.hittingButton == 8)//AVG Season
                {
                    textview.setText("Batting Average Leaders: Single Season");
                    tvAppend(textview, BATTING, 2);
                }
                else if(OffensiveButtons.hittingButton == 9)//AVG AT
                {
                    textview.setText("zWar Leaders: All Time");
                    tvAppend(textview, BATTING, 1);
                }
                else if(OffensiveButtons.hittingButton == 10)//AVG Season
                {
                    textview.setText("zWar Leaders: Single Season");
                    tvAppend(textview, BATTING, 2);
                }
            }
            else if(ButtonScreen.lastActivity == 2)// Pitching Button
            {
                if(PitchingButtons.pitchingButton == 1)//Wins All time
                {
                    textview.setText("Win Leaders: All Time");
                    tvAppend(textview, PITCHING, 1);
                }
                else if(PitchingButtons.pitchingButton == 2)//Wins single season
                {
                    textview.setText("Win Leaders: Single Season");
                    tvAppend(textview, PITCHING, 2);
                }
                else if(PitchingButtons.pitchingButton == 3)//SO All time
                {
                    textview.setText("Strike Out Leaders: All Time");
                    tvAppend(textview, PITCHING, 1);
                }
                else if(PitchingButtons.pitchingButton == 4)//SO single season
                {
                    textview.setText("Strike Out Leaders: Single Season");
                    tvAppend(textview, PITCHING, 2);
                }
                else if(PitchingButtons.pitchingButton == 5)
                {
                    textview.setText("Earned Run Average Leaders: All Time");
                    tvAppend(textview, PITCHING, 1);
                }
                else if(PitchingButtons.pitchingButton == 6)
                {
                    textview.setText("Earned Run Average Leaders: Single Season");
                    tvAppend(textview, PITCHING, 2);
                }
                else if(PitchingButtons.pitchingButton == 7)
                {
                    textview.setText("zWar Leaders: All Time");
                    tvAppend(textview, PITCHING, 1);
                }
                else if(PitchingButtons.pitchingButton == 8)
                {
                    textview.setText("zWar Leaders: Single Season");
                    tvAppend(textview, PITCHING, 2);
                }
                else if(PitchingButtons.pitchingButton == 9)
                {
                    textview.setText("WHIP Leaders: All Time");
                    tvAppend(textview, PITCHING, 1);
                }
                else if(PitchingButtons.pitchingButton == 10)
                {
                    textview.setText("WHIP Leaders: Single Season");
                    tvAppend(textview, PITCHING, 2);
                }
            }
        }
        catch(JSONException e){
            e.printStackTrace();
        }
    }
    private void tvAppend(TextView textview, int category, int buttonType) throws JSONException {
        if(category == PITCHING)
        {
            theString = new JSONObject(PitchingButtons.pitchingJSONData);
            JSONArray jsonArray = theString.optJSONArray("players");
            textview.append("\n");
            if(buttonType == 1)
            {
                for(int i = 0; i < jsonArray.length(); i++){
                    JSONObject jobj = jsonArray.getJSONObject(i);
                    String nameWins = i + 1 + ". " + jobj.getString("firstName") + " "+ jobj.getString("lastName") + " - " + jobj.get("total");
                    textview.append(nameWins);
                    textview.append("\n");
                }
            }
            if(buttonType == 2)
            {
                for(int i = 0; i < jsonArray.length(); i++){
                    JSONObject jobj = jsonArray.getJSONObject(i);
                    String nameWins = i + 1 + ". " + jobj.getString("firstName") + " " + jobj.getString("lastName") + " - " + jobj.getString("total") + " - " + jobj.getString("year") + " - " + teamNameTranslate(jobj.getString("team"));
                    textview.append(nameWins);
                    textview.append("\n");
                }
            }
        }
        else if(category == BATTING)
        {
            theString = new JSONObject(OffensiveButtons.offensiveJSONData);
            JSONArray jsonArray = theString.optJSONArray("players");
            textview.append("\n");
            if(buttonType == 1)
            {
                for(int i = 0; i < jsonArray.length(); i++){
                    JSONObject jobj = jsonArray.getJSONObject(i);
                    String nameWins = i + 1 + ". " + jobj.getString("firstName") + " "+ jobj.getString("lastName") + " - " + jobj.get("total");
                    textview.append(nameWins);
                    textview.append("\n");
                }
            }
            if(buttonType == 2)
            {
                for(int i = 0; i < jsonArray.length(); i++){
                    JSONObject jobj = jsonArray.getJSONObject(i);
                    String nameWins = i + 1 + ". " + jobj.getString("firstName") + " " + jobj.getString("lastName") + " - " + jobj.getString("total") + " - " + jobj.getString("year") + " - " + teamNameTranslate(jobj.getString("team"));
                    textview.append(nameWins);
                    textview.append("\n");
                }
            }
        }
    }
    private String teamNameTranslate(String teamID) {
        switch (teamID) {
            case "CHN":
                return "Chicago Cubs";
            case "NYA":
                return "New York Yankees";
            case "DET":
                return "Detroit Tigers";
            case "BOS":
                return "Boston Redsox";
            case "PHI":
                return "Philadelphia Phillies";
            case "PHA":
                return "Philadelphia Athletics";
            case "CLE":
                return "Cleveland Indians";
            case "TEX":
                return "Texas Rangers";
            case "SLN":
                return "St. Louis Cardinals";
            case "LAN":
                return "Los Angeles Dodgers";
            case "CHA":
                return "Chicago White Sox";
            case "COL":
                return "Colorado Rockies";
            case "CIN":
                return "Cincinnati Reds";
            case "OAK":
                return "Oakland Athletics";
            case "MON":
                return "Montreal Expos";
            case "HOU":
                return "Houston Astros";
            case "ANA":
                return "Los Angeles Angels";
            case "SEA":
                return "Seattle Mariners";
            case "TOR":
                return "Toronto Blue Jays";
            case "NY1":
                return "New York Giants";
            case "SFN":
                return "San Francisco Giants";
            case "MIN":
                return "Minnesota Twins";
            case "BAL":
                return "Baltimore Orioles";
            case "KCA":
                return "Kansas City Royals";
            case "TBR":
                return "Tampa Bay Rays";
            case "SDN":
                return "San Diego Padres";
            case "ARI":
                return "Arizona Diamondbacks";
            case "MIA":
                return "Miami Marlins";
            case "ATL":
                return "Atlanta Braves";
            case "PIT":
                return "Pittsburgh Pirates";
            case "WSH":
                return "Washington Nationals";
            case "NYN":
                return "New York Mets";
            case "MIL":
                return "Milwaukee Brewers";
            case "BRO":
                return "Brooklyn Dodgers";
            case "FLA":
                return "Florida Marlins";
            default:
                return teamID;
        }
    }
}

