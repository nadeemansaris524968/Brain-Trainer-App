package com.example.nadee.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Boolean isPlaying;
    Button controllerBTN;
    CountDownTimer countDownTimer;
    TextView timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isPlaying = false;
        controllerBTN = (Button) findViewById(R.id.controllerBTN);
        timer = (TextView) findViewById(R.id.timer);
        countDownTimer = new CountDownTimer(30100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.i("CountDown Timer", "time passed"+millisUntilFinished);
                String toDisplay = "0:00";
                int time = (int)(millisUntilFinished / 1000);
                if (time <= 9){
                    toDisplay = "0:0"+Integer.toString(time);
                }
                else {
                    toDisplay = "0:"+Integer.toString(time);
                }
                timer.setText(toDisplay);
            }

            @Override
            public void onFinish() {
                Log.i("CountDown Timer", "Finished!");
                timer.setText("0:00");
            }
        };
    }

    public void controllerBTN(View view){
        if (isPlaying){
            isPlaying = false;
            Log.i("Game State", "is playing: "+isPlaying.toString());
            controllerBTN.setText("Stop");
            countDownTimer.start();
        }
        else {
            isPlaying = true;
            Log.i("Game State", "is playing: "+isPlaying.toString());
            controllerBTN.setText("Play");
            timer.setText("0:00");
            countDownTimer.cancel();
        }
    }
}
