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
	protected double screenWidth;
	protected double screenHeight;

    public GameNode(double screenWidth, double screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setDestinationX(double destinationX) {
        this.destinationX = destinationX;
    }

    public void setDestinationY(double destinationY) {
        this.destinationY = destinationY;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSpeed() {
        return speed;
    }

    public double getRadius() {
        return radius;
    }

    public double getDestinationX() {
        return destinationX;
    }

    public double getDestinationY() {
        return destinationY;
    }

    public double getScreenWidth() {
        return screenWidth;
    }

    public double getScreenHeight() {
        return screenHeight;
    }


    public double xToPercent(double percent){

    	double x = getX();

    	x = (getScreenWidth()/100)*percent;

    	return x;
    } 

    public double yToPercent(double percent){

    	double y = getY();

    	y = (getScreenHeight()/100)*percent;

    	return y;
    }

    public double radiusToPercent(double percent){

    	double x = getX();

    	x = (getScreenWidth()/100)*percent;

    	return x;
    }

    public double speedToPercent(double percent){

    	double x = getX();

    	x = (getScreenWidth()/100)*percent;

    	return x;
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
