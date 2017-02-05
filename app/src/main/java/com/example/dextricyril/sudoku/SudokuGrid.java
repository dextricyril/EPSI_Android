package com.example.dextricyril.sudoku;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

public class SudokuGrid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku_grid);
        DrawView grid =new DrawView(this);
//        grid.Draw(new Canvas());
        setContentView(grid);

    }
}

class DrawView extends View {
    Paint paint = new Paint();

    public DrawView(Context context) {
        super(context);
        paint.setColor(Color.BLACK);
    }
    public void onDraw(Canvas canvas) {
        int GRID_WIDTH,GRID_HEIGHT;
        GRID_WIDTH=getWidth();
        GRID_HEIGHT=2*getHeight()/3;

        int side=GRID_WIDTH/11; //also margin

        for (int i=0;i<10;i++)
        {
            //Draw ROW
            canvas.drawRect(new Rect(side+i*side, side ,side+i*side +10, GRID_HEIGHT), paint);
//            DRAW LINE
            canvas.drawRect(new Rect(side, side+i*side-10 , GRID_WIDTH-side , side+i*side),paint);

        }


    }

}