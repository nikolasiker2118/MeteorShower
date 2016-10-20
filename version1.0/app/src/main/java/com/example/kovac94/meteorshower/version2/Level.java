package com.example.kovac94.meteorshower.version2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kovacmarko168 on 10/20/2016.
 */

public class Level {

	protected List<GameNode> enemys;


    public Level() {

    	enemys = new ArrayList<>();

    }

    public void addEnemy(GameNode gameNode){

		enemys.add(gameNode);

	}

    public List<GameNode> getEnemys() {
        
        return enemys;
    
    }

    public void removeEnemy(GameNode gameNode){

    	for (int i=0;i<getEnemys().size();i++){

    		if(getEnemys().get(i) == gameNode) getEnemys().remove(gameNode);

    	}
    }

   	public boolean nextLevel(){

   		if (getEnemys().size() == 0) return true;

   		return false;
   	}
}