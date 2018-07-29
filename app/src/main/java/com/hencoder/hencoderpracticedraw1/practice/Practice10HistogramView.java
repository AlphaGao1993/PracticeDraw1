package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends View {

    private String[] str = {"Froyo", "GB", "ICS", "JB", "KitKat", "L", "M"};
    Paint paint = new Paint();
    float[] xy = {100, 100, 100, 600, 100, 600, 1000, 600};
    int[] height = {10, 50, 50, 200, 400, 500, 200};
    Rect rect = new Rect();
    int startX = 120;
    int startY = 600;
    int dis = 20;
    int width = 100;

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(2);
        paint.setColor(Color.WHITE);
        canvas.drawLines(xy, paint);
        startX = 120;
        startX += width / 2;
        for (int i = 0; i < height.length; i++) {
            paint.setStrokeWidth(width);
            paint.setColor(Color.GREEN);
            canvas.drawLine(startX, startY, startX, startY - height[i], paint);

            paint.setTextSize(30);
            paint.getTextBounds(str[i], 0, str[i].length(), rect);
            paint.setColor(Color.WHITE);
            canvas.drawText(str[i], startX - rect.width() / 2, startY + 30, paint);
            startX += width + dis;
        }
//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
    }
}
