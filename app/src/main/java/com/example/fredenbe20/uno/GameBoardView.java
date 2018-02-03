package com.example.fredenbe20.uno;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.widget.ImageView;

/**
 * Created by fredenbe20 on 2/3/2018.
 */

public class GameBoardView extends SurfaceView {
    public GameBoardView(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public GameBoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
    }

    public GameBoardView(Context context, AttributeSet attrs, int defStyleAttrs) {
        super(context, attrs, defStyleAttrs);
        setWillNotDraw(false);
    }

    public void onDraw(Canvas canvas)
    {
        //drawing bottom cards
        Bitmap bmp = bitmapMaker(R.drawable.green_four,0);
        canvas.drawBitmap(bmp, 900f, getHeight() - 250f, null);
        bmp = bitmapMaker(R.drawable.blue_reverse, 0);
        canvas.drawBitmap(bmp, 1100f, getHeight() - 250f, null);
        bmp = bitmapMaker(R.drawable.red_one, 0);
        canvas.drawBitmap(bmp, 1300f, getHeight() - 250f, null);
        bmp = bitmapMaker(R.drawable.wild, 0);
        canvas.drawBitmap(bmp, 1500f, getHeight() - 250f, null);
        bmp = bitmapMaker(R.drawable.cover_card, 90);
        //drawing the left cards
        canvas.drawBitmap(bmp, 10f, 300f, null);
        canvas.drawBitmap(bmp, 10f, 500f, null);
        canvas.drawBitmap(bmp, 10f, 700f, null);
        canvas.drawBitmap(bmp, 10f, 900f, null);
        //drawing the right cards
        canvas.drawBitmap(bmp, getWidth() - 250, 300f, null);
        canvas.drawBitmap(bmp, getWidth() - 250, 500f, null);
        canvas.drawBitmap(bmp, getWidth() - 250, 700f, null);
        canvas.drawBitmap(bmp, getWidth() - 250, 900f, null);
        //drawing the top cards
        bmp = bitmapMaker(R.drawable.cover_card, 180);
        canvas.drawBitmap(bmp, 900f, 10f, null);
        canvas.drawBitmap(bmp, 1100f, 10f, null);
        canvas.drawBitmap(bmp, 1300f, 10f, null);
        canvas.drawBitmap(bmp, 1500f, 10f, null);
        //drawing deck and play stack
        bmp = bitmapMaker(R.drawable.cover_card, 0);

        canvas.drawBitmap(bmp, 1100f, 500f, null);
        bmp = bitmapMaker(R.drawable.wild_draw_four, 0);
        canvas.drawBitmap(bmp, 1300f, 500f, null);
        Paint black = new Paint(Color.BLACK);
        canvas.drawLine(300f, 0f, 300f, getHeight(), black);
        canvas.drawLine(getWidth() - 300f, 0f, getWidth() - 300f, getHeight(), black);
        canvas.drawLine(0f, 270f, getWidth(), 270f, black);
        canvas.drawLine(0f, getHeight() - 270f, getWidth(), getHeight() - 270f, black);
    }
    public static Bitmap RotateBitmap(Bitmap source, float angle){
        if(angle == 0){
            return source;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
        /**
         External Citation
         Date: 3 February 2018
         Problem: Needed to rotate the card
         Resource:
         http:https://stackoverflow.com/questions/9015372/
         how-to-rotate-a-bitmap-90-degrees
         Solution: I used the example code from this post.
         */

    }
    public Bitmap bitmapMaker(int ID, float angle){
        return RotateBitmap(BitmapFactory.decodeResource(getResources(),ID), angle);

    }
}

