package com.example.kovac94.meteorshower.version2;

import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;


/**
 * Created by kovacmarko168 on 10/20/2016.
 */

public class GameNode {

	protected double x;
	protected double y;
	protected double speed;
	protected double radius; 
	protected double destinationX;
	protected double destinationY;

    public GameNode(double x, double y, double speed, double radius, double destinationX, double destinationY) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.radius = radius;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getDestinationX() {
        return destinationX;
    }

    public void setDestinationX(double destinationX) {
        this.destinationX = destinationX;
    }

    public double getDestinationY() {
        return destinationY;
    }

    public void setDestinationY(double destinationY) {
        this.destinationY = destinationY;
    }

    public void move(){

        double disX=getDestinationX()-getX();
        double disY=getDestinationY()-getY();

        if (sqrt(disY*disY+disX*disX)<getSpeed()){
            setX(getDestinationX()); 
            setY(getDestinationY());
        }
        else {
            double radian = atan2(disY,disX);
            setX(getX()+cos(radian)*getSpeed());
            setY(getY()+sin(radian)*getSpeed());
        }
	}
}
