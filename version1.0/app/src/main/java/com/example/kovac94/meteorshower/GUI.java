package com.example.kovac94.meteorshower;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by kovacmarko168 on 10/12/2016.
 */

public class GUI extends View implements View.OnTouchListener{

    Paint paint;
    Player player;
    Thread thread = Thread.currentThread();
    List<Meteor> meteors;
    Random randomGenerator = new Random();

    public GUI(Context context) {
        super(context);
        paint = new Paint();
        setOnTouchListener(this);
        meteors = new ArrayList<>();
    }

    //Player creation
    private void initPlayer() {

        this.player = new Player(getWidth()/2,getHeight()-10);
    }

    //Meteor creation
    private void initMeteor(){

        //Meteor position and destination
        //Random destinationX
        int low = 10;
        int high = getWidth()-10;
        int destX = randomGenerator.nextInt(high-low) + low;

        //Random x
        int x = randomGenerator.nextInt(high-low) + low;
        int y = -20;

        meteors.add(new Meteor(x,y,destX,getHeight()));
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        if (player==null) initPlayer();
        if(meteors.isEmpty()) initMeteor();

        canvas.drawColor(Color.argb(255,43,43,43));

        //Draw player
        paint.setColor(Color.argb(255,76,192,128));
        canvas.drawCircle(player.x,player.y,player.radius,paint);

        for(int i=0;i<meteors.size();i++){

            meteors.get(i).move();

            //check if meteor destination is reached
            if(meteors.get(i).x==meteors.get(i).destinationX && meteors.get(i).y==meteors.get(i).destinationY){
                meteors.remove(meteors.get(i));
                initMeteor();
            }

            //Draw meteor
            paint.setColor(Color.RED);
            canvas.drawCircle(meteors.get(i).x,meteors.get(i).y,meteors.get(i).radius,paint);


            //Check if player destination is reached
            if (player.x==player.destinationX && player.y==player.destinationY && player.destinationX!=getWidth()/2 && player.destinationY!=getHeight()-10){

                //damage area effect
                paint.setColor(Color.argb(255,76,192,128));
                player.radius = 50;
                canvas.drawCircle(player.x,player.y,player.radius,paint);


                List<Meteor> destroyMeteors = new ArrayList<>();
                for(int p=0;p<meteors.size();p++){
                    if((meteors.get(p).x-player.x)*(meteors.get(p).x-player.x)+(meteors.get(p).y-player.y)*(meteors.get(p).y-player.y)<=(meteors.get(p).radius+player.radius)*(meteors.get(p).radius+player.radius)){
                        destroyMeteors.add(meteors.get(p));
                        initMeteor();
                        initMeteor();
                    }

                }

                for(int h=0;h<destroyMeteors.size();h++){
                    meteors.remove(destroyMeteors.get(h));

                }

                initPlayer();
            }
        }


        player.move();

        //Force to redraw everything
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
