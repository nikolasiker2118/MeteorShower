package com.example.kovac94.meteorshower.version2;

/**
 * Created by kovacmarko168 on 10/20/2016.
 */

public class Rocket extends GameNode {

    public Rocket(double screenWidth, double screenHeight) {
        super(screenWidth, screenHeight);

        //width = 960
        //height = 540

        setX(xToPercent(100)/2);
        setY(yToPercent(100)-yToPercent(8.333));
        setRadius(radiusToPercent(1.042));
        setSpeed(speedToPercent(1.042));
    }


    /*
    public void collisionDetectionCheck(GameNode gameNode){

    	List<Meteor> destroyMeteors = new ArrayList<>();

    	for(int p=0;p<meteors.size();p++){
            if((meteors.get(p).getX()-player.getRocket().getX())*(meteors.get(p).getX()-player.getRocket().getX())+(meteors.get(p).getY()-player.getRocket().getY())*(meteors.get(p).getY()-player.getRocket().getY())<=(meteors.get(p).getRadius()+player.getRocket().getRadius())*(meteors.get(p).getRadius()+player.getRocket().getRadius())){
                destroyMeteors.add(meteors.get(p));

                initMeteor();
                initMeteor();

                player.setScore(player.getScore()+100);

            }
        }

        for(int h=0;h<destroyMeteors.size();h++) meteors.remove(destroyMeteors.get(h));

        player.setRocket(initRocket());

    }
    */
}
