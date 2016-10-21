package com.example.kovac94.meteorshower.score;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kovac94.meteorshower.R;

import org.json.JSONArray;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

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

        // Adding hardcoded data into list for testing purposes
        sc1 = new Scores(0, 2500, 120, "Nikola", "Easy");
        Scores sc2 = new Scores(1, 5360, 500, "Marko", "Easy");
        list.add(sc1);
        list.add(sc2);
        ListView listView = (ListView) findViewById(R.id.listView1);

        // Setting adapter for listview element
        ScoresAdapter adapter = new ScoresAdapter(this, R.layout.list_view_layout, list);
        listView.setAdapter(adapter);

        // Creating JSONArray and putting data into it
        JSONArray array = new JSONArray();
        for (int i = 0; i < list.size(); i++){
            array.put(list.get(i).getJSONObject());
        }

        // Serializing JSONArray in file
        Writer output = null;
        File file = new File("storage/emulated/0/JsonShower.json");
        try {
            output = new BufferedWriter(new FileWriter(file));
            output.write(array.toString());
            output.close();
            Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Array: " + array.toString());


    }
    

}
