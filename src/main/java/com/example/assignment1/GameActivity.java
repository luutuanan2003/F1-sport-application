package com.example.assignment1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.os.Looper;
import android.os.SystemClock;
import android.widget.Toast;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class GameActivity extends AppCompatActivity {
    private boolean dialogIsShown = false;
    TextView textView;
    Button reset, start, stop;
    RadioButton red, yellow, green;
    int seconds, minutes, milliSeconds;
    long millisecondTime, startTime, timeBuff, updateTime = 0L ;
    Handler handler;
    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try { if(minutes == 60 && seconds == 60 && milliSeconds == 999){
                throw new Exception("Stopwatch has exceeded its limit! Please press RESET");
            }
                millisecondTime = SystemClock.uptimeMillis() - startTime;
                updateTime = timeBuff + millisecondTime;
                seconds = (int) (updateTime / 1000);
                minutes = seconds / 60;
                seconds = seconds % 60;
                milliSeconds = (int) (updateTime % 1000);

                textView.setText(MessageFormat.format("{0}:{1}:{2}", minutes, String.format(Locale.getDefault(), "%02d", seconds), String.format(Locale.getDefault(), "%01d", milliSeconds)));
                handler.postDelayed(this, 0);
            } catch (Exception e) {
                Toast.makeText(GameActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game);


        Button backtohome = (Button) findViewById(R.id.game_home);
        backtohome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        Button backtogame = (Button) findViewById(R.id.game_stats);
        backtogame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameActivity.this, StatsActivity.class);
                startActivity(intent);
                finish();
            }
        });


        textView = (TextView) findViewById(R.id.Timer);
        reset = findViewById(R.id.Reset);
        start = findViewById(R.id.Start);
        stop = findViewById(R.id.Stop);
        red = findViewById(R.id.red);
        yellow = findViewById(R.id.yellow);
        green = findViewById(R.id.green);
        // Disable the radio buttons
        red.setEnabled(false);
        yellow.setEnabled(false);
        green.setEnabled(false);
        reset.setEnabled(false);
        stop.setEnabled(false);
        start.setEnabled(true);


        handler = new Handler(Looper.getMainLooper());





        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset.setEnabled(false);
                stop.setEnabled(false);
                start.setEnabled(false);
                red.setChecked(true);

                handler.postDelayed(() -> {
                    yellow.setChecked(true);

                    handler.postDelayed(() -> {
                        green.setChecked(true);

                        // After setting the colors, start the timer and update UI
                        startTime = SystemClock.uptimeMillis();
                        handler.postDelayed(runnable, 0);
                        stop.setEnabled(true);

                    }, 3000); // Delay for 3 seconds between yellow and green
                }, 3000); // Delay for 3 seconds between red and yellow
            }
        });


        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeBuff += millisecondTime;
                handler.removeCallbacks(runnable);
                reset.setEnabled(true);
                stop.setEnabled(false);
                start.setEnabled(true);
                dialogIsShown = true;
                if (seconds <= 0){
                    AlertDialog alertDialog = new AlertDialog.Builder(GameActivity.this).create();
                    alertDialog.setTitle("RESULTS");
                    alertDialog.setMessage("Your Reaction Is Just Like F1 Driver, MAX VERSTAPPEN!");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "READ MORE?", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(GameActivity.this, StatsActivity.class);
                            startActivity(intent);
                            finish();
                            dialog.dismiss();
                            dialogIsShown = false;
                        }
                    });
                    alertDialog.show();
                } else if (seconds <= 2){
                    AlertDialog alertDialog = new AlertDialog.Builder(GameActivity.this).create();
                    alertDialog.setTitle("RESULTS");
                    alertDialog.setMessage("Your Reaction Is Just Like F1 Driver, SERGIO PEREZ!");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "READ MORE?", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(GameActivity.this, StatsActivity.class);
                            startActivity(intent);
                            finish();
                            dialog.dismiss();
                            dialogIsShown = false;
                        }
                    });
                    alertDialog.show();
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(GameActivity.this).create();
                    alertDialog.setTitle("RESULTS");
                    alertDialog.setMessage("Your Reaction Is Just Like F1 Driver, LEWIS HAMILTON!");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "READ MORE?", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(GameActivity.this, StatsActivity.class);
                            startActivity(intent);
                            finish();
                            dialog.dismiss();
                            dialogIsShown = false;
                        }
                    });
                    alertDialog.show();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                millisecondTime = 0L ;
                startTime = 0L ;
                timeBuff = 0L ;
                updateTime = 0L ;
                seconds = 0 ;
                minutes = 0 ;
                milliSeconds = 0 ;
                textView.setText("00:00:00");
                red.setChecked(false);
                yellow.setChecked(false);
                green.setChecked(false);

            }
        });

        textView.setText("00:00:00");
    }
}