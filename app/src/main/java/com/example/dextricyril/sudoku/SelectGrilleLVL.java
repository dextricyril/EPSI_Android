package com.example.dextricyril.sudoku;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.TwoLineListItem;

import java.util.ArrayList;



//TODO create a treatemnt to create all vGrid
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
        ArrayList <vGrid> TOAST = new ArrayList<vGrid>();
        vGrid testGrid = new vGrid(2);
        TOAST.add(testGrid);
        vGrid testGrid2 = new vGrid(52);
        TOAST.add(testGrid);
        TOAST.add(testGrid2);
        MyAdapter polom = new MyAdapter(this,TOAST);

        ArrayAdapter< String> adapter = new ArrayAdapter< String>
                (this, android.R.layout.simple_list_item_1,android.R.id.text1,values);

        list.setAdapter(polom);
        list.setClickable(true);
/*
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
//        intention.putExtra("selectedLevel",level); send difficulty and level
        startActivity(intention);
    }

    public void vGridGenerator(int difficulty)
    {

    }
}


class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<vGrid> items;

    public MyAdapter(Context context, ArrayList<vGrid> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TwoLineListItem twoLineListItem;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            twoLineListItem = (TwoLineListItem) inflater.inflate(
                    android.R.layout.simple_list_item_2, null);
        } else {
            twoLineListItem = (TwoLineListItem) convertView;
        }
        TextView text1 = twoLineListItem.getText1();
        TextView text2 = twoLineListItem.getText2();
        text1.setText(items.get(position).num + "   niveau:" + (double) items.get(position).level);
        text2.setText(items.get(position).done+" %");
        text2.setTextSize(22);
        if (items.get(position).done < 40)
            text2.setTextColor(Color.RED);
        else
            text2.setTextColor(Color.GREEN);
       Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Munro.ttf");
       text2.setTypeface(typeface);
        return twoLineListItem;
    }

}