package com.example.dextricyril.sudoku;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;


public class SelectGrilleLVL extends AppCompatActivity implements View.OnClickListener{
    Context context =this;
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
        list.setClickable(true);

        list.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView <?> parentAdapter, View view, int position,
                                    long id) {
                goToGrid();}
        });
            /*
            @Override//TODO set up popup
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Object o = list.getItemAtPosition(position);
                new AlertDialog.Builder(context)
                        .setView(R.layout.popup)
                        .setTitle("")
                        .setMessage("Are you sure you want to delete this entry?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }});*/
    }


    @Override
    public void onClick(View v) {

    }

    public void goToGrid()
    {
        Intent intention = new Intent(this, SudokuGrid.class);
//        intention.putExtra("selectedLevel",level);
        startActivity(intention);
    }


}
