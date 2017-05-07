package com.example.nadee.braintrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Boolean isPlaying;
    Button controllerBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isPlaying = false;
        controllerBTN = (Button) findViewById(R.id.controllerBTN);
    }

    public void controllerBTN(View view){
        if (isPlaying){
            isPlaying = false;
            Log.i("Game State", "is playing: "+isPlaying.toString());
            controllerBTN.setText("Play");
        }
        else {
            isPlaying = true;
            Log.i("Game State", "is playing: "+isPlaying.toString());
            controllerBTN.setText("Stop");
        }
    }
}
