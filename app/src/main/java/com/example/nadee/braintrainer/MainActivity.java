package com.example.nadee.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startBTN;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button playAgainBTN;
    TextView sumTextView;
    TextView scoreTextView;
    TextView resultTextView;
    TextView timerTextView;
    int score = 0;
    ArrayList<Integer> answers = new ArrayList<>();
    int locationOfCorrectAnswer;
    int numberOfQuestions = 0;

    public void start(View view){
        startBTN.setVisibility(View.INVISIBLE);
        sumTextView.setVisibility(View.VISIBLE);
        resultTextView.setVisibility(View.VISIBLE);
        scoreTextView.setVisibility(View.VISIBLE);
        timerTextView.setVisibility(View.VISIBLE);
        button0.setVisibility(View.VISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.playAgainBTN));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = (TextView)findViewById(R.id.resultTextView);

        scoreTextView = (TextView) findViewById(R.id.scoreTextView);

        startBTN = (Button) findViewById(R.id.startBTN);
        startBTN.setVisibility(View.VISIBLE);
        timerTextView = (TextView)findViewById(R.id.timerTextView);

        playAgainBTN = (Button)findViewById(R.id.playAgainBTN);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        sumTextView = (TextView)findViewById(R.id.sumTextView);

        sumTextView.setVisibility(View.INVISIBLE);
        resultTextView.setVisibility(View.INVISIBLE);
        scoreTextView.setVisibility(View.INVISIBLE);
        timerTextView.setVisibility(View.INVISIBLE);
        playAgainBTN.setVisibility(View.INVISIBLE);
        button0.setVisibility(View.INVISIBLE);
        button1.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.INVISIBLE);
    }

    public void chooseAnswer(View view){
        if (view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))){
            score++;
            resultTextView.setText("Correct!");
        }
        else {
            resultTextView.setText("Wrong!");
        }
        numberOfQuestions++;
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
        generateQuestion();

    }

    public void generateQuestion(){
        Random random = new Random();
        int a = random.nextInt(21);
        int b = random.nextInt(21);

        sumTextView.setText(a+" + "+b);

        locationOfCorrectAnswer = random.nextInt(4);
        answers.clear();
        int incorrectAnswer;

        for (int i=0;i<4;i++){
            if (i == locationOfCorrectAnswer) {
                answers.add(a + b);
            }
            else {
                incorrectAnswer = random.nextInt(41);
                while (incorrectAnswer == a+b){
                    incorrectAnswer = random.nextInt(41);
                }
                answers.add(incorrectAnswer);
            }
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }

    public void playAgain(View view){
        score = 0;
        numberOfQuestions = 0;
        timerTextView.setText("30s");
        scoreTextView.setText("0/0");
        resultTextView.setText("");
        playAgainBTN.setVisibility(View.INVISIBLE);
        generateQuestion();

        new CountDownTimer(30100, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                playAgainBTN.setVisibility(View.VISIBLE);
                timerTextView.setText("0s");
                resultTextView.setText("Your score: "+Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
            }
        }.start();
    }
}
