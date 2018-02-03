package com.example.fredenbe20.uno;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;

public class UnoGameScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uno_game_screen);
        SurfaceView surfaceView = (SurfaceView)findViewById(R.id.surfaceView);

        surfaceView.setBackgroundColor(Color.WHITE);
    }

}
