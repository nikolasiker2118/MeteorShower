package com.example.kovac94.meteorshower.game;

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

    Paint paint,lifeBarPaint;
    Player player;
    Thread thread = Thread.currentThread();
    List<Meteor> meteors;
    Random randomGenerator = new Random();

    public GUI(Context context) {
        super(context);
        paint = new Paint();
        
        //life bar paint init
        lifeBarPaint = new Paint();
        lifeBarPaint.setColor(Color.argb(255,245,35,84));
        
        setOnTouchListener(this);
        meteors = new ArrayList<>();
    }

    //Player creation
    private void initPlayer() {

        this.player = new Player(this.initRocket());
    }

    //Rocket creation
    private Rocket initRocket() {

        Rocket rocket = new Rocket(getWidth()/2,getHeight()-45,10,10,false);
        
        return rocket;
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

        meteors.add(new Meteor(x,y,destX,getHeight(),20));
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        if (player==null)initPlayer();
        if(meteors.isEmpty()) initMeteor();
        

        canvas.drawColor(Color.argb(255,43,43,43));

        //Draw player
        paint.setColor(Color.argb(255,76,192,128));
        canvas.drawCircle((float)player.getRocket().getX(),(float)player.getRocket().getY(),(float)player.getRocket().getRadius(),paint);

        //Draw life bar
        lifeBarPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(10,getHeight()-30,getWidth()-10,getHeight()-10,lifeBarPaint);


        for(int i=0;i<meteors.size();i++){

            meteors.get(i).move();

            //check if meteor destination is reached
            if(meteors.get(i).getX()==meteors.get(i).getDestinationX() && meteors.get(i).getY()==meteors.get(i).getDestinationY()){
                meteors.remove(meteors.get(i));
                initMeteor();
            }

            //Draw meteor
            paint.setColor(Color.RED);
            canvas.drawCircle((float)meteors.get(i).getX(),(float)meteors.get(i).getY(),(float)meteors.get(i).getRadius(),paint);


            //Check if player destination is reached
            if (player.getRocket().getX()==player.getRocket().getDestinationX() && player.getRocket().getY()==player.getRocket().getDestinationY() && player.getRocket().getDestinationX()!=getWidth()/2 && player.getRocket().getDestinationY()!=getHeight()-10){

                //damage area effect
                paint.setColor(Color.argb(255,76,192,128));
                player.getRocket().setRadius(50);
                canvas.drawCircle((float)player.getRocket().getX(),(float)player.getRocket().getY(),(float)player.getRocket().getRadius(),paint);


                List<Meteor> destroyMeteors = new ArrayList<>();
                for(int p=0;p<meteors.size();p++){
                    if((meteors.get(p).getX()-player.getRocket().getX())*(meteors.get(p).getX()-player.getRocket().getX())+(meteors.get(p).getY()-player.getRocket().getY())*(meteors.get(p).getY()-player.getRocket().getY())<=(meteors.get(p).getRadius()+player.getRocket().getRadius())*(meteors.get(p).getRadius()+player.getRocket().getRadius())){
                        destroyMeteors.add(meteors.get(p));

                        initMeteor();
                        initMeteor();

                        //if meteor is destroyed you gain 100 points
                        player.setScore(player.getScore()+100);

                    }

                }

                for(int h=0;h<destroyMeteors.size();h++){
                    meteors.remove(destroyMeteors.get(h));

                }

                player.setRocket(initRocket());
            }
        }

        
        player.getRocket().move();

        //Draw score
        paint.setColor(Color.WHITE);
        paint.setTextSize(30);
        canvas.drawText("Score:"+player.getScore(),5,50,paint);


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
            if (player.getRocket().isMoving()!=true){
                player.getRocket().setMoving(true);
                player.getRocket().setDestinationX(event.getX());
                player.getRocket().setDestinationY(event.getY());
            }
        }

        return false;
    }
}
