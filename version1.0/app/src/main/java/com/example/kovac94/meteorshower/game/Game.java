package com.example.kovac94.meteorshower.game;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.kovac94.meteorshower.version2.GameView;

public class Game extends Activity implements View.OnTouchListener {

    GUI gui;
    GameView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //fullscreen mode
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //gui = new GUI(this);
        
        gv = new GameView(this);
        gv.setOnTouchListener(this);
        setContentView(gv);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        return false;
    }

}
