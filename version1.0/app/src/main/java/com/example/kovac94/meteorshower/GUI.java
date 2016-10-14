package com.example.kovac94.meteorshower;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

/**
 * Created by kovacmarko168 on 10/12/2016.
 */

public class GUI extends View implements View.OnTouchListener{

    Paint paint;
    Player player;
    Meteor meteor;
    Thread thread = Thread.currentThread();

    Random randomGenerator = new Random();

    public GUI(Context context) {
        super(context);
        paint = new Paint();
        setOnTouchListener(this);
    }

    //init player object
    private void initPlayer() {

        //Player creation
        this.player = new Player(getWidth()/2,getHeight()-10);

    }

    private void initMeteor(){
        //Meteor position and destination
        //Random destinationX
        int low = 10;
        int high = getWidth()-10;
        int destX = randomGenerator.nextInt(high-low) + low;

        //Random x
        int x = randomGenerator.nextInt(high-low) + low;
        int y = -20;

        //Create meteor
        //new Meteor(x,destinationX,destinationY);
        this.meteor = new Meteor(x,y,destX,getHeight());
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        if (player==null) initPlayer();
        if (meteor==null) initMeteor();

        canvas.drawColor(Color.argb(255,43,43,43));

        //DRAW->MOVE(UPDATE)->REDRAW
        //Draw player
        paint.setColor(Color.argb(255,76,192,128));
        canvas.drawCircle(player.x,player.y,player.radius,paint);
        paint.setColor(Color.MAGENTA);
        canvas.drawLine(player.x,player.y,player.destinationX,player.destinationY,paint);


        //Draw meteor
        paint.setColor(Color.RED);
        canvas.drawCircle(meteor.x,meteor.y,meteor.radius,paint);
        paint.setColor(Color.BLUE);
        canvas.drawLine(meteor.x,meteor.y,meteor.destinationX,meteor.destinationY,paint);


        if(player.x==player.destinationX && player.y==player.destinationY) initPlayer();
        if(meteor.x==meteor.destinationX && meteor.y==meteor.destinationY) initMeteor();

        //Collusion detection between meteor and player
        if((meteor.x-player.x)*(meteor.x-player.x)+
                (meteor.y-player.y)*(meteor.y-player.y)<=(meteor.radius+meteor.radius)*(meteor.radius+meteor.radius)){

            initMeteor();
            initPlayer();
        }

        player.move();
        meteor.move();

        invalidate();

        try {
            thread.sleep(22);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if (event.getAction()==MotionEvent.ACTION_DOWN){

            //If player.move = true then you can't change the player destination
            //You can choose player destination only once
            if (player.moving!=true){
                player.moving = true;
                player.destinationX = (float)event.getX();
                player.destinationY = (float)event.getY();
            }
        }

        return false;
    }
}
