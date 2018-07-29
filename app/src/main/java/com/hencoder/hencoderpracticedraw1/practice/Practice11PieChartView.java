package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {

    Paint paint = new Paint();
    float[] ratios = {0.32F, 0.12F, 0.01F, 0.05F, 0.04F, 0.18F, 0.28F};
    private String[] str = {"Lollipop", "Marshmallow", "Froyo", "Gingerbread", "Icon Cream Sandwich", "Jelly Bean", "KitKat"};
    int[] colors = {Color.RED, Color.YELLOW, Color.BLACK, Color.BLUE, Color.DKGRAY, Color.MAGENTA, Color.GREEN};
    int specialPos = 0;
    int centerX = 450;
    int centerY = 300;

    int radius = 250;
    Float startAngle = -180F;
    float marginAngle = 2F;

    RectF rectF = new RectF();
    Rect textRect = new Rect();

    int lineVertical = 30;
    int lineHorienzental = 100;

    Path path = new Path();

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);

        float sum = 0;
        for (int i = 0; i < str.length; i++) {
            float angle = (360 - marginAngle * str.length) * ratios[i];

            int currentCenterX = centerX;
            int currentCenterY = centerY;
            if (specialPos == i) {
                currentCenterY += (int) (Math.sin(((startAngle + angle / 2)) / 180 * Math.PI) * 20);
                currentCenterX += (int) (Math.cos(((startAngle + angle / 2)) / 180 * Math.PI) * 20);
            }

            rectF.left = currentCenterX - radius;
            rectF.top = currentCenterY - radius;
            rectF.right = currentCenterX + radius;
            rectF.bottom = currentCenterY + radius;

            paint.setColor(colors[i]);
            canvas.drawArc(rectF, startAngle, angle, true, paint);

            int startY = currentCenterY + (int) (Math.sin(((startAngle + angle / 2)) / 180 * Math.PI) * radius);
            int startX = currentCenterX + (int) (Math.cos(((startAngle + angle / 2)) / 180 * Math.PI) * radius);

            boolean isPointLeft = false;    //指示线是否向左延伸

            if (startX < centerX) {
                isPointLeft = true;
            }

            paint.setColor(Color.WHITE);
            paint.setStrokeWidth(2);

            float y = currentCenterY + (int) (Math.sin(((startAngle + angle / 2)) / 180 * Math.PI) * (radius + lineVertical));
            float x = currentCenterX + (int) (Math.cos(((startAngle + angle / 2)) / 180 * Math.PI) * (radius + lineVertical));

            float endX = x + (isPointLeft ? -lineHorienzental : lineHorienzental);
            canvas.drawLine(startX, startY, x, y, paint);
            canvas.drawLine(x, y, endX, y, paint);

            paint.setColor(Color.WHITE);
            paint.setTextSize(30F);
            paint.setTextAlign(isPointLeft ? Paint.Align.LEFT : Paint.Align.RIGHT);
            paint.getTextBounds(str[i], 0, str[i].length(), textRect);
            canvas.drawText(str[i], endX + (isPointLeft ? -textRect.width() - 20 : textRect.width() + 20), y + 10, paint);
            
            startAngle += angle + marginAngle;
        }
    }
}
