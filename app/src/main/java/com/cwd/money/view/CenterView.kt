package com.cwd.money.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.cwd.money.utils.Util
import java.lang.Math.*

class CenterView : BaseView{

    private var paint:Paint? = null

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    init {
        paint = Paint()
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint?.isAntiAlias = true
        canvas?.translate(width/2f,height/2f)

        val t = width/3
        val r = 72
        val aa = 2 * PI / 360

        canvas?.rotate(-90f);
//        计算5个顶点坐标
        val  a = arrayOf((Math.cos(0 * aa) * t),  (sin(0 * aa) * t));
        val  b = arrayOf((Math.cos(r * aa) * t), (sin(r * aa) * t));
        val  c = arrayOf((Math.cos(r * 2 * aa) * t),  (-sin(r * 2 * aa) * t))
        val  d = arrayOf((Math.cos(r * 3 * aa) * t),  (-sin(r * 3 * aa) * t))
        val  e = arrayOf( (Math.cos(r * 4 * aa) * t),  (sin(r * 4 * aa) * t))

//        五角星阴影
//        paint.setStrokeWidth(2f);
//        paint.setColor(Color.BLACK);
//        paint.setStyle(Paint.Style.FILL);
//        val path1 = Path();
//        path1.moveTo((a[0] - 100).toFloat(), (a[1] + 100).toFloat());
//        path1.lineTo(d[0].toFloat(), d[1].toFloat());
//        path1.lineTo((e[0] - 50).toFloat(), (e[1] + 100).toFloat());
//        path1.lineTo((b[0] - 50).toFloat(), (b[1] + 50).toFloat());
//        path1.lineTo(c[0].toFloat(), c[1].toFloat());
//        path1.close();
//        canvas?.drawPath(path1, paint);


//        画五角星
        paint?.setStrokeWidth(2f);
        paint?.setColor(Color.RED);
        paint?.setStyle(Paint.Style.FILL);
        val path =  Path();
        path.moveTo(a[0].toFloat(), a[1].toFloat());
        path.lineTo(d[0].toFloat(), d[1].toFloat());
        path.lineTo(e[0].toFloat(), e[1].toFloat());
        path.lineTo(b[0].toFloat(), b[1].toFloat());
        path.lineTo(c[0].toFloat(), c[1].toFloat());
        path.close();
        canvas?.drawPath(path, paint!!);


//        中心到顶点的连线
        paint?.setStrokeWidth(1f);
        paint?.setColor(Color.BLACK);
        paint?.setStyle(Paint.Style.STROKE);
        canvas?.drawLine(0f, 0f, a[0].toFloat(), a[1].toFloat(), paint!!);
        canvas?.drawLine(0f, 0f, b[0].toFloat(), b[1].toFloat(), paint!!);
        canvas?.drawLine(0f, 0f, c[0].toFloat(), c[1].toFloat(), paint!!);
        canvas?.drawLine(0f, 0f, d[0].toFloat(), d[1].toFloat(), paint!!);
        canvas?.drawLine(0f, 0f, e[0].toFloat(), e[1].toFloat(), paint!!);

//        五角星内外接圆大小
        val tt = t * sin(18 * aa) / sin((180 - 36 - 18) * aa);
//        内接圆
//        canvas.drawCircle(0, 0, (float) tt, mDeafultPaint);
        val rr=36;
        //        计算5个交叉点坐标
        val a1 = arrayOf((Math.cos(rr * aa) * tt), (sin(rr * aa) * tt));
        val b1 = arrayOf( (Math.cos(rr * 3 * aa) * tt),  (sin(rr * 3 * aa) * tt));
        val c1 = arrayOf((Math.cos(rr* 5 * aa) * tt), (-sin(rr * 5 * aa) * tt));
        val d1 = arrayOf( (Math.cos(rr * 7 * aa) * tt), (sin(rr * 7 * aa) * tt));
        val e1 = arrayOf( (Math.cos(rr * 9 * aa) * tt), (sin(rr * 9 * aa) * tt));

//        中心到交叉点的连线
        paint?.setColor(Color.RED);
        canvas?.drawLine(0f, 0f, a1[0].toFloat(), a1[1].toFloat(), paint!!);
        canvas?.drawLine(0f, 0f, b1[0].toFloat(), b1[1].toFloat(), paint!!);
        canvas?.drawLine(0f, 0f, c1[0].toFloat(), c1[1].toFloat(), paint!!);
        canvas?.drawLine(0f, 0f, d1[0].toFloat(), d1[1].toFloat(), paint!!);
        canvas?.drawLine(0f, 0f, e1[0].toFloat(), e1[1].toFloat(), paint!!);
    }




    override fun onDestroy(){
        super.onDestroy()
        paint = null
    }



}