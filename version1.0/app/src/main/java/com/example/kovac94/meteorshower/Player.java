package com.example.kovac94.meteorshower;

import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

/**
 * Created by kovacmarko168 on 10/12/2016.
 */

public class Player {

    float x;
    float y;
    float radius = 10;
    float destinationX;
    float destinationY;
    float speed = 10;
    boolean moving = false;

    public Player(float x, float y) {
        this.x = x;
        this.y = y;
        this.destinationX=this.x;
        this.destinationY=this.y;
    }

    public void move() {

        float disX=this.destinationX-this.x;
        float disY=this.destinationY-this.y;

        if (sqrt(disY*disY+disX*disX)<this.speed){
            this.x = this.destinationX;
            this.y = this.destinationY;
        }
        else {
            double radian = atan2(disY,disX);
            this.x+=cos(radian)*this.speed;
            this.y+=sin(radian)*this.speed;
        }

    }
}
