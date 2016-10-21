package com.example.kovac94.meteorshower.version2;

import java.util.Random;

/**
 * Created by kovacmarko168 on 10/20/2016.
 */

public class Meteor extends GameNode {

	protected Random random;

    public Meteor(double screenWidth, double screenHeight) {
        super(screenWidth, screenHeight);

        random = new Random();
        //createMeteor();
    }

    /*
    public void createMeteor(){

    	double mixX = 10; // xtoPercent(something)
    	double maxX = getWidth()-10; //xtoPercent(getWidth(100)-xtoPercent(something))
        double destX = random.nextInt(maxX-minX) + minX;

        //Random x
        double x = random.nextInt(maxX-minX) + minX; //setX(something)
        double y = -20; //setY(yToPercent(something))

    }
	*/

}
