package com.example.kovac94.meteorshower;

import java.util.Random;

import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.floor;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

/**
 * Created by kovacmarko168 on 10/13/2016.
 */

public class Meteor {

    float x;
    float y;
    float destinationX;
    float destinationY;
    float radius = 20;
    float speed = 5;

    public Meteor(float x, float y, float destinationX, float destinationY) {
        this.x = x;
        this.y = y;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
    }

    public void move() {

        float disX = this.destinationX - this.x;
        float disY = this.destinationY - this.y;

        if (sqrt(disY * disY + disX * disX) < this.speed) {
            this.x = this.destinationX;
            this.y = this.destinationY;
        } else {
            double radian = atan2(disY, disX);
            this.x += cos(radian) * this.speed;
            this.y += sin(radian) * this.speed;
        }
    }
}