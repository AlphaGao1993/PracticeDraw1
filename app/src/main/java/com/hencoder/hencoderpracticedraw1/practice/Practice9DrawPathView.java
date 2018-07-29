package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    Paint paint = new Paint();
    RectF rectF = new RectF();
    Path path = new Path();

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        rectF.left = 300;
        rectF.top = 200;
        rectF.right = 500;
        rectF.bottom = 400;
        path.addArc(rectF, -220, 220);
        path.lineTo(500, 550);
        path.close();
        canvas.drawPath(path, paint);
        path.reset();
        rectF.left = 500;
        rectF.top = 200;
        rectF.right = 700;//园直径 200
        rectF.bottom = 400;
        path.addArc(rectF, -180, 220);
        path.lineTo(500, 550);
        path.close();
        canvas.drawPath(path, paint);
//        练习内容：使用 canvas.drawPath() 方法画心形
    }
}
