package com.example.kovac94.meteorshower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Leaderboard extends AppCompatActivity {

    ArrayList <Scores> list= new ArrayList<Scores>();
    Scores sc1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_leaderboard);
        sc1 = new Scores(0, 2500, 120, "Nikola", "Easy");
        Scores sc2 = new Scores(1, 5360, 500, "Marko", "Easy");
        list.add(sc1);
        list.add(sc2);
        ListView listView = (ListView) findViewById(R.id.listView1);
        ScoresAdapter adapter = new ScoresAdapter(this, R.layout.list_view_layout, list);
        listView.setAdapter(adapter);
        int i = 0;
        for (Scores temp: list){

        }
    }

}
