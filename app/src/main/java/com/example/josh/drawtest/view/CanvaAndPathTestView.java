package com.example.josh.drawtest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Josh on 2017/12/20.
 */

public class CanvaAndPathTestView extends View {


    public CanvaAndPathTestView(Context context) {
        this(context,null);
    }

    public CanvaAndPathTestView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CanvaAndPathTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
//    Path path=new Path();
//    {
//        // 使用 path 对图形进行描述（这段描述代码不必看懂）
//        path.addArc(new RectF(200, 200, 400, 400), -225, 225);
//        path.arcTo(new RectF(400, 200, 600, 400),  -180, 225, false);
//        path.lineTo(400, 542);
//    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setTextSize(20);
        paint.setColor(Color.parseColor("#87b953"));
        canvas.drawText("Canvas.drawPath绘制自定义图形",50,25,paint);
        //path添加圆形，椭圆，矩形等其他用法一致
        Path path1=new Path();
        path1.addCircle(100,100,50,Path.Direction.CW);
        canvas.drawPath(path1,paint);

        paint.setStyle(Paint.Style.STROKE);
        //path画线,绿色
        Path path2=new Path();
        path2.moveTo(20,200);//定位初始位置
        path2.lineTo(80,180);//画线到绝对位置
        path2.lineTo(180,200);//画线到绝对位置
        path2.rLineTo(-20,20);//画线到相对位置
        canvas.drawPath(path2,paint);

        //path画贝塞尔曲线,橙色
        Path path3=new Path();
        paint.setColor(Color.parseColor("#e4513f"));
        path3.moveTo(20,200);//定位初始位置
        path3.quadTo(80,180,180,200);//画线到绝对位置
        path3.rQuadTo(-20,20,20,20);//画线到相对位置
        canvas.drawPath(path3,paint);

        //path画二次贝塞尔曲线，蓝色
        Path path4=new Path();
        paint.setColor(Color.parseColor("#69aad7"));
        path4.moveTo(20,200);
        path4.cubicTo(80,180,180,200,160,220);
        canvas.drawPath(path4,paint);

        paint.setColor(Color.parseColor("#87b953"));
        //path画扇形轮廓,forceMoveTo代表是否强行移动，不留下痕迹
        Path path5=new Path();
        path5.moveTo(20,250);
        path5.rLineTo(50,20);
        path5.arcTo(new RectF(100,270,180,310),270,100,false);
        canvas.drawPath(path5,paint);

        //封闭图形，close,连接终点和起点
        Path path6=new Path();
        path6.moveTo(20,300);
        path6.rLineTo(50,20);
        path6.arcTo(new RectF(100,320,180,360),270,100,false);
        path6.close();;
        canvas.drawPath(path6,paint);

        //封闭图形，paint的style设置成FILL或者FILL_AND_STROKE,自动封闭图形并填充
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        Path path7=new Path();
        path7.moveTo(20,350);
        path7.rLineTo(50,20);
        path7.arcTo(new RectF(100,370,180,410),270,100,false);
        canvas.drawPath(path7,paint);

        //填充模式，even-odd rule 奇偶原则，
        // 点发出射线与图形相交的次数，偶数为外部，奇数为内部
        Path path8=new Path();
        path8.setFillType(Path.FillType.EVEN_ODD);
        path8.addCircle(60,460,50,Path.Direction.CW);
        path8.addCircle(85,460,50,Path.Direction.CW);
        path8.addCircle(100,460,50,Path.Direction.CW);
        canvas.drawPath(path8,paint);

        //填充模式，non-zero winding rule 非零环绕数原则，
        // 点发出射线与图形相交，顺时针加+1，逆时针-1的，总数为0为外部，其他为内部
        //图形均为顺时针时，完全填充
        Path path9=new Path();
        path9.setFillType(Path.FillType.WINDING);
        path9.addCircle(60,600,50,Path.Direction.CW);
        path9.addCircle(85,600,50,Path.Direction.CW);
        path9.addCircle(100,600,50,Path.Direction.CW);
        canvas.drawPath(path9,paint);
        //有顺时针和逆时针的WINDING填充示例
        Path path10=new Path();
        path10.setFillType(Path.FillType.WINDING);
        path10.addCircle(60,750,50,Path.Direction.CCW);//逆时针
        path10.addCircle(85,750,50,Path.Direction.CW);
        path10.addCircle(100,750,50,Path.Direction.CW);
        canvas.drawPath(path10,paint);

    }
}
