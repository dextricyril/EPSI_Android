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
import android.widget.Button;

import static android.R.attr.textSize;

public class SudokuGrid extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku_grid);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button)findViewById(R.id.button7);
        button8 = (Button)findViewById(R.id.button8);
        button9 = (Button)findViewById(R.id.button9);


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
        int textSize = 65;
        paint.setTextSize(textSize);

        String res ="008203500009670408346050702430010059967005001000496203280034067703500904004107020";
        int side=GRID_WIDTH/11; //also margin

        for(int i=0;i<9;i++) {
            for (int j = 0; j < 9; j++) {

                int x = side + j * side+(int)side/3;
                int y = (int)2*side + i * side-17;//it shows my love for magic number
                int value = i * 9 + j;
                String myLetter=res.substring(value, value + 1);
                System.out.println(x + " " + y + " " + value + myLetter);
                if(!myLetter.equals("0")) {
                    canvas.drawText(res.substring(value, value + 1), x, y, paint);
                }
            }

        }

        for (int i=0;i<10;i++)
        {
            //Draw ROW
            canvas.drawRect(new Rect(side+i*side, side ,side+i*side +10, GRID_HEIGHT), paint);
//            DRAW LINE
            canvas.drawRect(new Rect(side, side+i*side-10 , GRID_WIDTH-side , side+i*side),paint);

        }


    }



}