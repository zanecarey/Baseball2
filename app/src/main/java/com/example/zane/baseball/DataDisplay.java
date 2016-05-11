package com.example.zane.baseball;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataDisplay extends AppCompatActivity {
    JSONObject theString = null;
    static final int BATTING = 1;
    static final int PITCHING = 2;
    int isZWAR = 0;
    int isWHIP = 0;
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
                    textview.setText("          Homerun Leaders: All Time\n\n");
                    textview.append("    Name                 HR    \n");
                    textview.append("____________________________________________\n");
                    tvAppend(textview, BATTING, 1);
                }
                else if(OffensiveButtons.hittingButton == 2)//HR SINGLE SEASON
                {
                    textview.setText("          Homerun Leaders: Single Season\n\n");
                    textview.append("    Name                HR   Year    Team\n");
                    textview.append("____________________________________________\n");
                    tvAppend(textview, BATTING, 2);
                }
                else if(OffensiveButtons.hittingButton == 3)//RBI ALL TIME
                {
                    textview.setText("          RBI Leaders: All Time\n\n");
                    textview.append("    Name                 RBI    \n");
                    textview.append("____________________________________________\n");
                    tvAppend(textview, BATTING, 1);
                }
                else if(OffensiveButtons.hittingButton == 4)//RBI SEASON
                {
                    textview.setText("          RBI Leaders: Single Season\n\n");
                    textview.append("    Name                RBI   Year   Team\n");
                    textview.append("____________________________________________\n");
                    tvAppend(textview, BATTING, 2);
                }
                else if(OffensiveButtons.hittingButton == 5)//SB AT
                {
                    textview.setText("          Stolen Base Leaders: All Time\n\n");
                    textview.append("    Name                 SB    \n");
                    textview.append("____________________________________________\n");
                    tvAppend(textview, BATTING, 1);
                }
                else if(OffensiveButtons.hittingButton == 6)//SB Season
                {
                    textview.setText("          Stolen Base Leaders: Single Season\n\n");
                    textview.append("    Name                SB   Year    Team\n");
                    textview.append("____________________________________________\n");
                    tvAppend(textview, BATTING, 2);
                }
                else if(OffensiveButtons.hittingButton == 7)//AVG AT
                {
                    textview.setText("          Batting Average Leaders: All Time\n\n");
                    textview.append("    Name                  AVG    \n");
                    textview.append("____________________________________________\n");
                    tvAppend(textview, BATTING, 1);
                }
                else if(OffensiveButtons.hittingButton == 8)//AVG Season
                {
                    textview.setText("       Batting Average Leaders: Single Season\n\n");
                    textview.append("    Name                AVG   Year  Team\n");
                    textview.append("____________________________________________\n");
                    tvAppend(textview, BATTING, 2);
                }
                else if(OffensiveButtons.hittingButton == 9)//zwar AT
                {
                    textview.setText("          zWar Leaders: All Time\n\n");
                    textview.append("    Name                 zWAR    \n");
                    textview.append("____________________________________________\n");
                    tvAppend(textview, BATTING, 1);
                }
                else if(OffensiveButtons.hittingButton == 10)//zwar Season
                {
                    textview.setText("          zWar Leaders: Single Season\n\n");
                    textview.append("    Name                zWAR   Year  Team\n");
                    textview.append("____________________________________________\n");
                    isZWAR = 1;
                    tvAppend(textview, BATTING, 2);
                }
            }
            else if(ButtonScreen.lastActivity == 2)// Pitching Button
            {
                if(PitchingButtons.pitchingButton == 1)//Wins All time
                {
                    textview.setText("          Win Leaders: All Time\n\n");
                    textview.append("    Name                 W    \n");
                    textview.append("____________________________________________\n");
                    tvAppend(textview, PITCHING, 1);
                }
                else if(PitchingButtons.pitchingButton == 2)//Wins single season
                {
                    textview.setText("          Win Leaders: Single Season\n\n");
                    textview.append("    Name                W    Year   Team\n");
                    textview.append("____________________________________________\n");
                    tvAppend(textview, PITCHING, 2);
                }
                else if(PitchingButtons.pitchingButton == 3)//SO All time
                {
                    textview.setText("          Strike Out Leaders: All Time\n\n");
                    textview.append("    Name                SO    \n");
                    textview.append("____________________________________________\n");
                    tvAppend(textview, PITCHING, 1);
                }
                else if(PitchingButtons.pitchingButton == 4)//SO single season
                {
                    textview.setText("          Strike Out Leaders: Single Season\n\n");
                    textview.append("    Name                SO   Year  Team\n");
                    textview.append("____________________________________________\n");
                    tvAppend(textview, PITCHING, 2);
                }
                else if(PitchingButtons.pitchingButton == 5)
                {
                    textview.setText("          Earned Run Average Leaders: All Time\n\n");
                    textview.append("    Name                ERA    \n");
                    textview.append("____________________________________________\n");
                    tvAppend(textview, PITCHING, 1);
                }
                else if(PitchingButtons.pitchingButton == 6)
                {
                    textview.setText("         Earned Run Average Leaders: Single Season\n\n");
                    textview.append("    Name                ERA   Year  Team\n");
                    textview.append("____________________________________________\n");
                    tvAppend(textview, PITCHING, 2);
                }
                else if(PitchingButtons.pitchingButton == 7)
                {
                    textview.setText("          zWar Leaders: All Time\n\n");
                    textview.append("    Name                zWAR    \n");
                    textview.append("____________________________________________\n");
                    isZWAR = 1;
                    tvAppend(textview, PITCHING, 1);
                }
                else if(PitchingButtons.pitchingButton == 8)
                {
                    textview.setText("          zWar Leaders: Single Season\n\n");
                    textview.append("    Name                zWAR   Year  Team\n");
                    textview.append("____________________________________________\n");
                    isZWAR = 1;
                    tvAppend(textview, PITCHING, 2);
                }
                else if(PitchingButtons.pitchingButton == 9)
                {
                    textview.setText("          WHIP Leaders: All Time\n\n");
                    textview.append("    Name                WHIP    \n");
                    textview.append("____________________________________________\n");
                    isWHIP = 1;
                    tvAppend(textview, PITCHING, 1);
                }
                else if(PitchingButtons.pitchingButton == 10)
                {
                    textview.setText("          WHIP Leaders: Single Season\n\n");
                    textview.append("    Name                WHIP   Year  Team \n");
                    textview.append("____________________________________________\n");
                    isWHIP = 1;
                    tvAppend(textview, PITCHING, 2);
                }
            }
            else if(ButtonScreen.lastActivity == 3)
            {
                if(ButtonScreen.notFound==1)
                {
                    textview.append("Player " + ButtonScreen.firstName + " " + ButtonScreen.lastName + " not found  (Check Spelling)");
                }
                else if(ButtonScreen.batterSearch ==1)
                {
                    textview.setText("          Stats for: " + ButtonScreen.firstName + " " + ButtonScreen.lastName);
                    theString = new JSONObject(ButtonScreen.result);
                    JSONArray jsonArray = theString.optJSONArray("players");
                    textview.append("\n");
                    textview.append("____________________________________________");
                    textview.append("\n");
                    textview.append("\n");
                    for(int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject jobj = jsonArray.getJSONObject(i);

                        String playerStats1 = "-Year- -Team- -Hits- -HR-  -Rbi- -Avg-  -SB-";
                        String playerStats2 = " " + jobj.getString("year") + "   " + jobj.getString("team") + "    " + statAlignment(jobj.getString("h")) + "    " + statAlignment(jobj.getString("hr")) + "   " + statAlignment(jobj.getString("rbi")) +
                                " " + jobj.getString("avg").substring(0, jobj.getString("avg").length()-1).replaceFirst("0", " ") + "    " + jobj.getString("sb");
                        String playerStats3 = "-SO-   -Runs- -SF-   -HBP- -G-   -zWar- -BB-";
                        String playerStats4 = " " + statAlignment(jobj.getString("so")) + "    " + statAlignment(jobj.getString("r")) + "    " + statAlignment(jobj.getString("sf")) + "    " + statAlignment(jobj.getString("hbp"))
                                + "   " + statAlignment(jobj.getString("g")) + "   " + statAlignment(jobj.getString("zwar").substring(0, jobj.getString("zwar").length()-1)) + "   " + statAlignment(jobj.getString("bb"));
                        textview.append(playerStats1);
                        textview.append("\n");
                        textview.append(playerStats2);
                        textview.append("\n");
                        textview.append(playerStats3);
                        textview.append("\n");
                        textview.append(playerStats4);
                        textview.append("\n");
                        textview.append("____________________________________________");
                        textview.append("\n");
                        textview.append("\n");
                    }
                    ButtonScreen.batterSearch = 0;
                }
                else if(ButtonScreen.pitcherSearch == 1)
                {
                    textview.setText("          Stats for: " + ButtonScreen.firstName + " " + ButtonScreen.lastName);
                    theString = new JSONObject(ButtonScreen.result);
                    JSONArray jsonArray = theString.optJSONArray("players");
                    textview.append("\n");
                    textview.append("____________________________________________");
                    textview.append("\n");
                    textview.append("\n");

                    for(int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jobj = jsonArray.getJSONObject(i);

                        String playerStats1 = "-Year- -Team- -W-  -SO-  -ERA- -IP-   -GS-";
                        String playerStats2 = " " + jobj.getString("year") + "   " + jobj.getString("team") + "    " + statAlignment(jobj.getString("w")) + "  " + statAlignment(jobj.getString("so")) + "   " + statAlignment(jobj.getString("era")) +
                                "  " + statAlignment(jobj.getString("ip").substring(0, 3))+ "    " + jobj.getString("gs");
                        String playerStats3 = "-HR-   -H-    -BB- -HBP- -WHIP--zWar- -SV-";
                        String playerStats4 = " " + statAlignment(jobj.getString("hr")) + "    " + statAlignment(jobj.getString("h")) + "    " + statAlignment(jobj.getString("bb")) + "  " + statAlignment(jobj.getString("hbp"))
                                + "   " + statAlignment(jobj.getString("whip")).substring(0, 3) + "   " + statAlignment(jobj.getString("zwar").substring(0, 4)) + "   " + statAlignment(jobj.getString("sv"));
                        textview.append(playerStats1);
                        textview.append("\n");
                        textview.append(playerStats2);
                        textview.append("\n");
                        textview.append(playerStats3);
                        textview.append("\n");
                        textview.append(playerStats4);
                        textview.append("\n");
                        textview.append("____________________________________________");
                        textview.append("\n");
                        textview.append("\n");
                    }
                    ButtonScreen.pitcherSearch = 0;
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
            String numAlign = "";
            if(buttonType == 1)
            {
                for(int i = 0; i < jsonArray.length(); i++){
                    if(i >=0 && i <=8)
                        numAlign = "  ";
                    else if(i >= 9 && i <= 98)
                        numAlign = " ";
                    else
                        numAlign = "";
                    JSONObject jobj = jsonArray.getJSONObject(i);
                    String nameConcat = jobj.getString("firstName") + " " + jobj.getString("lastName");
                    String nameWins = "";
                    if(isZWAR == 1)
                    {
                        nameWins = i + 1 + "." + numAlign + statAlignment(nameConcat) + jobj.getString("total").substring(0, 5);
                    }
                    else if(isWHIP == 1)
                    {
                        nameWins = i + 1 + "." + numAlign + statAlignment(nameConcat) + jobj.getString("total").substring(0, 4);
                    }
                    else
                    {
                        nameWins = i + 1 + "." + numAlign + statAlignment(nameConcat) + jobj.getString("total");
                    }
                    textview.append(nameWins);
                    textview.append("\n");
                }
            }
            if(buttonType == 2)
            {
                for(int i = 0; i < jsonArray.length(); i++){
                    if(i >=0 && i <=8)
                        numAlign = "  ";
                    else if(i >= 9 && i <= 98)
                        numAlign = " ";
                    else
                        numAlign = "";
                    JSONObject jobj = jsonArray.getJSONObject(i);
                    String nameConcat = jobj.getString("firstName") + " " + jobj.getString("lastName");
                    String nameWins = "";
                    if(isZWAR == 1)
                    {
                        nameWins = i + 1 + "." + numAlign + statAlignment(nameConcat) + statAlignment(jobj.getString("total").substring(0, 2)) + "    " + jobj.get("year") + "  " + teamNameTranslate(jobj.getString("team"));
                    }
                    else if(isWHIP == 1)
                    {
                        nameWins = i + 1 + "." + numAlign + statAlignment(nameConcat) + statAlignment(jobj.getString("total").substring(0, 4)) + "   " + jobj.get("year") + "  " + teamNameTranslate(jobj.getString("team"));
                    }
                    else
                    {
                        nameWins = i+1 + "." + numAlign + statAlignment(nameConcat) + statAlignment(jobj.getString("total")) + "  " + jobj.getString("year") + "   " + teamNameTranslate(jobj.getString("team"));
                    }
                    //nameWins = i + 1 + ". " + jobj.getString("firstName") + " " + jobj.getString("lastName") + " - " + jobj.getString("total") + " - " + jobj.getString("year") + " - " + teamNameTranslate(jobj.getString("team"));
                    textview.append(nameWins);
                    textview.append("\n");
                }
            }
        }
        else if(category == BATTING)
        {
            theString = new JSONObject(OffensiveButtons.offensiveJSONData);
            JSONArray jsonArray = theString.optJSONArray("players");
            String numAlign = "";
            if(buttonType == 1)
            {
                for(int i = 0; i < jsonArray.length(); i++){
                    JSONObject jobj = jsonArray.getJSONObject(i);
                    if(i >=0 && i <=8)
                        numAlign = "  ";
                    else if(i >= 9 && i <= 98)
                        numAlign = " ";
                    else
                        numAlign = "";
                    String nameConcat = jobj.getString("firstName") + " " + jobj.getString("lastName");
                    String nameWins = "";
                    //if the stat is avg, remove leading 0 and make 3 digits
                    if(jobj.getString("total").charAt(0) == '0')
                    {
                        nameWins = i+1 + "." + numAlign + statAlignment(nameConcat) + " " + jobj.getString("total").substring(0, jobj.getString("total").length()-1).replaceFirst("0", " ");
                    }
                    else
                    {
                        nameWins = i+1 + "." + numAlign + statAlignment(nameConcat) + " " + jobj.getString("total");
                    }
                    textview.append(nameWins);
                    textview.append("\n");
                }
            }
            if(buttonType == 2)
            {
                for(int i = 0; i < jsonArray.length(); i++){
                    JSONObject jobj = jsonArray.getJSONObject(i);
                    if(i >=0 && i <=8)
                        numAlign = "  ";
                    else if(i >= 9 && i <= 98)
                        numAlign = " ";
                    else
                        numAlign = "";
                    String nameConcat = jobj.getString("firstName") + " " + jobj.getString("lastName");
                    String nameWins = "";
                    if(jobj.getString("total").charAt(0) == '0')
                    {
                        nameWins = i+1 + "." + numAlign + statAlignment(nameConcat) + jobj.getString("total").substring(0, jobj.getString("total").length()-1).replaceFirst("0", "") + "  " + jobj.getString("year") + "   " + teamNameTranslate(jobj.getString("team"));
                    }
                    //if zwar season, remove 4th digit
                    else if(isZWAR == 1)
                    {
                        nameWins = i+1 + "." + numAlign + statAlignment(nameConcat) + jobj.getString("total").substring(0, jobj.getString("total").length()-1) + "  " + jobj.getString("year") + "   " + teamNameTranslate(jobj.getString("team"));
                    }
                    else
                    {
                        nameWins = i + 1 + "." + numAlign + statAlignment(nameConcat) + statAlignment(jobj.getString("total")) + "   " + jobj.getString("year") + "   " + teamNameTranslate(jobj.getString("team"));
                    }
                    textview.append(nameWins);
                    textview.append("\n");
                }
            }
        }
    }
    private String teamNameTranslate(String teamID) {
        switch (teamID) {
            case "CHN":
                return "Cubs";
            case "NYA":
                return "Yankees";
            case "DET":
                return "Tigers";
            case "BOS":
                return "Red Sox";
            case "PHI":
                return "Phillies";
            case "PHA":
                return "Athletics";
            case "CLE":
                return "Indians";
            case "TEX":
                return "Rangers";
            case "SLN":
                return "Cardinals";
            case "LAN":
                return "Dodgers";
            case "CHA":
                return "White Sox";
            case "COL":
                return "Rockies";
            case "CIN":
                return "Reds";
            case "OAK":
                return "A's";
            case "MON":
                return "Expos";
            case "HOU":
                return "Astros";
            case "ANA":
                return "Angels";
            case "LAA":
                return "Angels";
            case "SEA":
                return "Mariners";
            case "TOR":
                return "Blue Jays";
            case "NY1":
                return "Giants";
            case "SFN":
                return "Giants";
            case "MIN":
                return "Twins";
            case "BAL":
                return "Orioles";
            case "KCA":
                return "Royals";
            case "TBR":
                return "Rays";
            case "SDN":
                return "Padres";
            case "ARI":
                return "D-backs";
            case "MIA":
                return "Marlins";
            case "ATL":
                return "Braves";
            case "PIT":
                return "Pirates";
            case "WSH":
                return "Nationals";
            case "NYN":
                return "Mets";
            case "MIL":
                return "Brewers";
            case "BRO":
                return "Dodgers";
            case "FLO":
                return "Marlins";
            default:
                return teamID;
        }
    }
    private String statAlignment(String stat)
    {
        if(stat.length() == 1)
            return stat+="  ";
        else if(stat.length() == 2)
            return stat+=" ";
        else if(stat.length() == 3)
            return stat+="";
        else if(stat.length() == 7)
            return stat+="             ";
        else if(stat.length() == 8)
            return stat+="            ";
        else if(stat.length() == 9)
            return stat+="           ";
        else if(stat.length() == 10)
            return stat+="          ";
        else if(stat.length() == 11)
            return stat+="         ";
        else if(stat.length() == 12)
            return stat+="        ";
        else if(stat.length() == 13)
            return stat+="       ";
        else if(stat.length() == 14)
            return stat+="      ";
        else if(stat.length() == 15)
            return stat+="     ";
        else if(stat.length() == 16)
            return stat+="    ";
        else if(stat.length() == 17)
            return stat+="   ";
        else if(stat.length() == 18)
            return stat+="  ";
        else if(stat.length() == 19)
            return stat+=" ";
        else
            return stat;
    }
}

