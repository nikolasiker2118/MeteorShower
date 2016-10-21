package com.example.kovac94.meteorshower.version2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by kovacmarko168 on 10/20/2016.
 */

public class GameView extends SurfaceView implements Runnable{

    SurfaceHolder surfaceHolder;
    Thread t;
    boolean running = true;

    
    /* In-game objects */
    Player player;


    /* In-game objects */



    public GameView(Context context) {
        super(context);
        surfaceHolder = getHolder();
        t = new Thread(this);
        t.start();

    }


    @Override
    public void run() {

        while(running){

            if(!surfaceHolder.getSurface().isValid()) continue;



            Canvas canvas = surfaceHolder.lockCanvas();

            
            /* Draw game objects on the screen*/
            draw(canvas);

            /* Update game*/


            surfaceHolder.unlockCanvasAndPost(canvas);


        }

    }

    public void draw(Canvas canvas){


        /* Draw background */
        canvas.drawARGB(255,32,32,32);


        /*TEST*/
        Paint paint = new Paint();
        Rocket rocket = new Rocket(getWidth(),getHeight());
        paint.setColor(Color.argb(255,76,192,128));
        canvas.drawCircle((float)rocket.getX(),(float)rocket.getY(),(float)rocket.getRadius(),paint);


    }

}
 