package com.example.nadee.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Boolean isPlaying;
    Button controllerBTN;
    Button option1;
    Button option2;
    Button option3;
    Button option4;
    CountDownTimer countDownTimer;
    TextView timerTV;
    TextView questionsTV;
    Map<String, Integer> questionAnswers;
    String currentQuesKey;
    int answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionsTV = (TextView) findViewById(R.id.question);

        questionAnswers = new HashMap<>();
        questionAnswers.put("13+19?",32);
        questionAnswers.put("2*45?",90);
        questionAnswers.put("3+2?",5);

        currentQuesKey = "";
        answer = 0;

        option1 = (Button) findViewById(R.id.option1);
        option2 = (Button) findViewById(R.id.option2);
        option3 = (Button) findViewById(R.id.option3);
        option4 = (Button) findViewById(R.id.option4);

        displayNumbersOnButtons();

        isPlaying = false;
        controllerBTN = (Button) findViewById(R.id.controllerBTN);
        timerTV = (TextView) findViewById(R.id.timer);

        countDownTimer = new CountDownTimer(30100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.i("CountDown Timer", "time passed"+millisUntilFinished);
                workTimer(millisUntilFinished);
            }

            @Override
            public void onFinish() {
                Log.i("CountDown Timer", "Finished!");
                timerTV.setText("0:00");
            }
        };
    }

    public void controllerBTN(View view){
        if (isPlaying){
            isPlaying = false;
            Log.i("Game State", "is playing: "+isPlaying.toString());
            controllerBTN.setText("Play");
            timerTV.setText("0:00");
            countDownTimer.cancel();
        }
        else {
            isPlaying = true;
            Log.i("Game State", "is playing: "+isPlaying.toString());
            controllerBTN.setText("Stop");
            beginAskingQuestions();
            countDownTimer.start();
        }
    }

    public void displayNumbersOnButtons(){
        Random random = new Random();
        option1.setText(Integer.toString(random.nextInt(10)));
        option2.setText(Integer.toString(random.nextInt(10)));
        option3.setText(Integer.toString(random.nextInt(10)));
    }

    public void beginAskingQuestions(){
        if (isPlaying){

        }
    }

    public void workTimer(long millisUntilFinished){
        String toDisplay = "0:00";
        int time = (int)(millisUntilFinished / 1000);
        if (time <= 9){
            toDisplay = "0:0"+Integer.toString(time);
        }
        else {
            toDisplay = "0:"+Integer.toString(time);
        }
        timerTV.setText(toDisplay);
    }
}
