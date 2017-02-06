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

import java.io.File;
import java.util.ArrayList;



//TODO create a treatemnt to create all vGrid
public class SelectGrilleLVL extends AppCompatActivity implements View.OnClickListener{
    Context context =this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_select_grille_lvl1);
        final ListView list = (ListView) findViewById(R.id.liste);
        String s = getIntent().getStringExtra("selectedLevel");
        System.out.println(s +" debug");
        String[] values={"No Level Found"};
        MyAdapter adapterlist;
        switch (s) {
            case "LEVEL1":
                adapterlist = new MyAdapter(this,vGridGenerator(1));
                break;
            case "LEVEL2":
                adapterlist = new MyAdapter(this,vGridGenerator(2));
                break;
            default: adapterlist = new MyAdapter(this,vGridGenerator(1));
        }

        list.setAdapter(adapterlist);
        list.setClickable(true);

        list.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView <?> parentAdapter, View view, int position,
                                    long id) {
                goToGrid();}
        });
    }


    public void goToGrid()
    {
        Intent intention = new Intent(this, SudokuGrid.class);
        startActivity(intention);
    }

    public  ArrayList <vGrid> vGridGenerator(int difficulty)
    {
        ArrayList<vGrid> listGrid=new ArrayList<vGrid>();
        for (int i = 0; i<80;i++)
        {
            listGrid.add(new vGrid(i,difficulty,(int)(Math.random()*100)));
        }
        return listGrid;
    }

    @Override
    public void onClick(View v) {

    }
}
class vGrid
{
    protected int done;
    protected int level;
    protected int num;

    public vGrid(int num,int level,int done){
        this.num=num;
        this.level=level;
        this.done=done;
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