package com.example.dextricyril.sudoku;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button level1Button;
    Button level2Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        level1Button = (Button)findViewById(R.id.LEVEL1);
        level1Button.setOnClickListener(this);
        level2Button = (Button)findViewById(R.id.LEVEL2);
        level2Button.setOnClickListener(this);
        this.setTitle("Sudoku");
    }

    // cannot use a bundle for this api version (working with 19, min 21)
    public void onClick(View v) {
        if (v == level1Button) {
            String data="LEVEL1";
            selection(data);
        }
        if (v == level2Button) {
            String data="LEVEL2";
            selection(data);
        }
    }

    //call next window
    public void selection(String level)
    {
        Intent intention = new Intent(this, SelectGrilleLVL.class);
        intention.putExtra("selectedLevel",level);
        startActivity(intention);
    }
}
