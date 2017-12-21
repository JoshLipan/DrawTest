package com.example.josh.drawtest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Josh on 2017/12/20.
 */

/**
 * Canvas 简单图形的绘制测试类
 */
public class CanvaAndDrawTestView extends View {


    public CanvaAndDrawTestView(Context context) {
        this(context, null);
    }

    public CanvaAndDrawTestView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvaAndDrawTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);

    @Override

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //开启抗锯齿，或者初始化Paint时传入Paint.ANTI_ALIAS_FLAG
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#880000"));
        //设置paint风格，FILL 是填充模式，STROKE 是画线模式（即勾边模式），FILL_AND_STROKE 是两种模式一并使用：既画线又填充。它的默认值是 FILL，填充模式
        paint.setStyle(Paint.Style.FILL);

        //画布颜色调整，可用于画背景色或者覆盖效果
//        canvas.drawColor(getResources().getColor(R.color.colorPrimary));

        paint.setTextSize(20);
        canvas.drawText("Canvas 简单图形的绘制:",50,25,paint);
        //画圆:填充
        canvas.drawCircle(
                100,100,50,paint
        );
        //画图：画线
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        canvas.drawCircle(
                220,100,50,paint
        );
        //画图：画线又填充
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(20);
        canvas.drawCircle(
                350,100,50,paint
        );

        paint.setStrokeWidth(20);

        //画点，点的形状可以通过  paint.setStrokeCap(cap) 来设置：ROUND 画出来是圆形的点，SQUARE 或 BUTT 画出来是方形的点
        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(100,200,paint);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(150,200,paint);
        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(200,200,paint);
        //画多个点
        paint.setStrokeCap(Paint.Cap.ROUND);
        float[] pointsLocation={0,0,100,300,150,300,100,350,150,350};
        canvas.drawPoints(pointsLocation,2,8,paint);


        //画椭圆
        paint.setStyle(Paint.Style.FILL);
        RectF oval=new RectF(100,400,400,500);
        canvas.drawOval(oval,paint);
//        canvas.drawOval(100,400,400,500,paint);required API 21

        //画线
        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawLine(100,550,200,550,paint);
        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(100,600,200,600,paint);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(100,650,200,650,paint);
        //画多条线
        float[] lines={300,550,400,500,350,550,350,650,300,650,400,650};
        canvas.drawLines(lines,paint);


        //画圆角矩形
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(new RectF(100,700,200,800),20,20,paint);

        //画扇形，封口
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(new RectF(100,850,200,900),0,90,true,paint);
        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(new RectF(100,850,200,900),120,160,true,paint);
        //画扇形，不封口
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(new RectF(250,850,350,900),0,90,false,paint);
        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(new RectF(250,850,350,900),120,160,false,paint);

    }
}
