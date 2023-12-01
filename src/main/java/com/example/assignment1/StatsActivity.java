package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class StatsActivity extends AppCompatActivity {

    String maxInfo = "Max Verstappen, born in Belgium in 1997, is a Dutch Formula 1 driver. " +
            "He made his F1 debut at 17, setting the record as the youngest driver in the sport's history. " +
            "Verstappen races for Red Bull Racing, showcasing remarkable talent, aggressive racing style, " +
            "and became the youngest F1 World Champion in 2021.";

    String sergioInfo = "Sergio Pérez, born in Mexico in 1990, is a Formula 1 driver. " +
            "He joined F1 in 2011 and raced for various teams before joining Red Bull Racing in 2021. " +
            "Pérez is known for consistent performances, scoring podiums, " +
            "and supporting his team, becoming a valuable asset in the sport.";

    String lewisInfo = "Lewis Hamilton, born in the UK in 1985, is a seven-time Formula 1 World Champion. " +
            "Debuting in F1 in 2007, he's raced for Mercedes since 2013, securing numerous Grand Prix wins and championships. " +
            "Hamilton's talent, speed, and advocacy for diversity have made him a prominent figure in motorsport.";

    Drivers MaxV = new Drivers("Max Verstappen", 524, maxInfo, "Red Bull Racing");
    Drivers SergioP = new Drivers("Sergio Pérez", 258, sergioInfo, "Red Bull Racing");
    Drivers LewisH = new Drivers("Lewis Hamilton", 226, lewisInfo, "Mercedes");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_stats);

        TextView top1name = (TextView) findViewById(R.id.top1name);
        TextView top1points = (TextView) findViewById(R.id.top1points);
        TextView top1team = (TextView) findViewById(R.id.top1team);
        TextView top1info = (TextView) findViewById(R.id.top1info);
        top1name.setText(MaxV.getName());
        top1points.setText(MaxV.getPoints() +" points");
        top1team.setText(MaxV.getTeam());
        top1info.setText(MaxV.getInfo());


        TextView top2name = (TextView) findViewById(R.id.top2name);
        TextView top2points = (TextView) findViewById(R.id.top2points);
        TextView top2team = (TextView) findViewById(R.id.top2team);
        TextView top2info = (TextView) findViewById(R.id.top2text);
        top2name.setText(SergioP.getName());
        top2points.setText(SergioP.getPoints() +" points");
        top2team.setText(SergioP.getTeam());
        top2info.setText(SergioP.getInfo());

        TextView top3name = (TextView) findViewById(R.id.top3name);
        TextView top3points = (TextView) findViewById(R.id.top3points);
        TextView top3team = (TextView) findViewById(R.id.top3team);
        TextView top3info = (TextView) findViewById(R.id.top3text);
        top3name.setText(LewisH.getName());
        top3points.setText(LewisH.getPoints() +" points");
        top3team.setText(LewisH.getTeam());
        top3info.setText(LewisH.getInfo());


        Button backtohome = (Button) findViewById(R.id.game_home);
        backtohome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StatsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        Button backtogame = (Button) findViewById(R.id.stats_game);
        backtogame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StatsActivity.this, GameActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}