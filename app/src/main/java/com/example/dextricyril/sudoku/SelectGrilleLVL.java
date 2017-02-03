package com.example.dextricyril.sudoku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class SelectGrilleLVL extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_select_grille_lvl1);
        final ListView list = (ListView) findViewById(R.id.liste);
     //   list.setClickable(true);
        String s = getIntent().getStringExtra("selectedLevel");
        System.out.println(s +" debug");
        String[] values={"No Level Found"};
        switch (s) {
            case "LEVEL1":
                values = new String[]{"E1", "E2", "E3"};
                break;
            case "LEVEL2":
                values = new String[]{"Polom", "Test", "E3"};
                break;
        }

        ArrayAdapter< String> adapter = new ArrayAdapter< String>
                (this, android.R.layout.simple_list_item_1,android.R.id.text1,values);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Object o = list.getItemAtPosition(position);

            }
        });

        //list.setOnItemClickListener(adapter);
    }


    @Override
    public void onClick(View v) {

    }
}
