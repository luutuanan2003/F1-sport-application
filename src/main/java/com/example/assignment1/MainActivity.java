package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button Game;
    Button Stats,news1b, news2b,news3b, news4b,news5b,news6b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Game = (Button) findViewById(R.id.Home_Game);
        Stats = (Button) findViewById(R.id.Home_Stats);

        news1b = (Button) findViewById(R.id.news1button);
        news2b = (Button) findViewById(R.id.news2button);
        news3b = (Button) findViewById(R.id.news3button);
        news4b = (Button) findViewById(R.id.news4button);
        news5b = (Button) findViewById(R.id.news5button);
        news6b = (Button) findViewById(R.id.news6button);


        String url1 = "https://www.formula1.com/en/latest/article.leclerc-and-sainz-hopeful-that-monza-and-singapore-style-las-vegas-track.115C7vKmqs1MMYlgKJLpJO.html";
        String url2 = "https://www.formula1.com/en/latest/article.i-was-almost-in-tears-ocon-reflects-on-presenting-his-deadpool-inspired.6FrWtrQhukCtIWJdtPB2ET.html";
        String url3 = "https://www.formula1.com/en/latest/article.fp1-first-practice-session-in-las-vegas-brought-to-early-end-amid-red-flags.2jBEl8KmbU9FowFZCXMV4p.html#:~:text=The%20opening%20practice%20session%20for,the%20Las%20Vegas%20Strip%20Circuit.";
        String url4 = "https://www.formula1.com/en/latest/article.watch-carlos-sainz-brings-premature-end-to-free-practice-1-in-las-vegas-with.4nGMpmrQ3vqKeT3oOyifcu.html";
        String url5 = "https://www.formula1.com/en/latest/article.tremayne-the-architect-of-red-bulls-amazing-success-turns-50-today-but-who.25LKp0O9jwByycRuevm1Ng.html";
        String url6 = "https://www.formula1.com/en/latest/article.watch-cars-hit-the-track-for-the-first-time-at-the-las-vegas-strip-circuit.5i6PwyRDITouErLNNSuJWw.html";

        news1b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent link=new Intent(Intent.ACTION_VIEW, Uri.parse(url1));
                startActivity(link);
            }
        });

        news2b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent link=new Intent(Intent.ACTION_VIEW, Uri.parse(url2));
                startActivity(link);
            }
        });

        news3b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent link=new Intent(Intent.ACTION_VIEW, Uri.parse(url3));
                startActivity(link);
            }
        });

        news4b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent link=new Intent(Intent.ACTION_VIEW, Uri.parse(url4));
                startActivity(link);
            }
        });

        news5b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent link=new Intent(Intent.ACTION_VIEW, Uri.parse(url5));
                startActivity(link);
            }
        });

        news6b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent link=new Intent(Intent.ACTION_VIEW, Uri.parse(url6));
                startActivity(link);
            }
        });



        Game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intent);
                finish();
            }
        });


        Stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StatsActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }


}