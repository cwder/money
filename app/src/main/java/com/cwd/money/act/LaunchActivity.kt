package com.cwd.money.act

import android.graphics.Color.BLACK
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.cwd.money.databinding.ActivityLaunchBinding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.translate

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.cwd.money.R


class LaunchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLaunchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.composeView.apply {
            setContent {
                centerLayout()
            }
        }

    }


    @Preview
    @Composable
    fun centerLayout(){
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
            ){
            canvas()
        }
    }




    fun sleep(block:()->Unit){
        object : Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message) {
                block()
            }
        }.sendEmptyMessageDelayed(1,100)
    }


    override fun onDestroy() {
        super.onDestroy()
    }

    @Composable
    fun canvasTest(){
        Canvas(modifier = Modifier.size(200.dp), onDraw = {
            drawIntoCanvas {
                val p = Paint()
                translate(size.width/2f,size.height/2f){
                    it.drawRect(
                        left = 0f,
                        top = 0f,
                        right = 50f,
                        bottom = 50f,
                        paint = p
                    )
                }

            }




        })
    }

    @Composable
    fun canvas(){
        Canvas(modifier = Modifier.size(200.dp), onDraw = {
            //val paint = Paint()
            val width = size.width
            val canvasHeight = size.height
            translate(width/2f,canvasHeight/2f){
                val t = width/3
                val r = 72
                val aa = 2 * Math.PI / 360

                rotate(-90f){
                    val  a = arrayOf((Math.cos(0 * aa) * t),  (Math.sin(0 * aa) * t));
                    val  b = arrayOf((Math.cos(r * aa) * t), (Math.sin(r * aa) * t));
                    val  c = arrayOf((Math.cos(r * 2 * aa) * t),  (-Math.sin(r * 2 * aa) * t))
                    val  d = arrayOf((Math.cos(r * 3 * aa) * t),  (-Math.sin(r * 3 * aa) * t))
                    val  e = arrayOf( (Math.cos(r * 4 * aa) * t),  (Math.sin(r * 4 * aa) * t))
                    val path =  Path()
                    path.moveTo(a[0].toFloat(), a[1].toFloat())
                    path.lineTo(d[0].toFloat(), d[1].toFloat())
                    path.lineTo(e[0].toFloat(), e[1].toFloat())
                    path.lineTo(b[0].toFloat(), b[1].toFloat())
                    path.lineTo(c[0].toFloat(), c[1].toFloat())
                    path.close()
                    drawPath(
                        path = path,
                        color= Red
                    )
                    drawLine(
                        color = Black,
                        start = Offset(0f, 0f),
                        end = Offset(a[0].toFloat(), a[1].toFloat()),
                        strokeWidth = Stroke.HairlineWidth
                    )

                    drawLine(
                        color = Black,
                        start = Offset(0f, 0f),
                        end = Offset(b[0].toFloat(), b[1].toFloat()),
                        strokeWidth = Stroke.HairlineWidth
                    )

                    drawLine(
                        color = Black,
                        start = Offset(0f, 0f),
                        end = Offset(c[0].toFloat(), c[1].toFloat()),
                        strokeWidth = Stroke.HairlineWidth
                    )

                    drawLine(
                        color = Black,
                        start = Offset(0f, 0f),
                        end = Offset(d[0].toFloat(), d[1].toFloat()),
                        strokeWidth = Stroke.HairlineWidth
                    )

                    drawLine(
                        color = Black,
                        start = Offset(0f, 0f),
                        end = Offset(e[0].toFloat(), e[1].toFloat()),
                        strokeWidth = Stroke.HairlineWidth
                    )
                    //五角星内外接圆大小
                    val tt = t * Math.sin(18 * aa) / Math.sin((180 - 36 - 18) * aa);
                    val rr=36;
                    //        计算5个交叉点坐标
                    val a1 = arrayOf((Math.cos(rr * aa) * tt), (Math.sin(rr * aa) * tt));
                    val b1 = arrayOf( (Math.cos(rr * 3 * aa) * tt),  (Math.sin(rr * 3 * aa) * tt));
                    val c1 = arrayOf((Math.cos(rr* 5 * aa) * tt), (-Math.sin(rr * 5 * aa) * tt));
                    val d1 = arrayOf( (Math.cos(rr * 7 * aa) * tt), (Math.sin(rr * 7 * aa) * tt));
                    val e1 = arrayOf( (Math.cos(rr * 9 * aa) * tt), (Math.sin(rr * 9 * aa) * tt));


                }
            }
        })
    }
}