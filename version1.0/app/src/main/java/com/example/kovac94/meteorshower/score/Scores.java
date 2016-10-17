package com.example.kovac94.meteorshower.score;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by nikolan on 10/13/2016.
 */

public class Scores {
    int id, score, time_played;
    String nick, difficulty;

    public Scores (){}

    public Scores(int id, int score, int time_played, String nick, String difficulty){
        this.id = id;
        this.score = score;
        this.time_played = time_played;
        this.nick = nick;
        this.difficulty = difficulty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTime_played() {
        return time_played;
    }

    public void setTime_played(int time_played) {
        this.time_played = time_played;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }


    public JSONObject getJSONObject() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("id", id);
            obj.put("nick", nick);
            obj.put("score", score);
            obj.put("time_played", time_played);
        } catch (JSONException e) {
            System.out.println("DefaultListItem.toString JSONException: "+e.getMessage());
        }
        return obj;
    }

}
