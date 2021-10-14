package com.cwd.money.act

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import com.cwd.money.databinding.ActivityLaunchBinding
import com.cwd.money.utils.startActivity

class LaunchActivity : AppCompatActivity() {

    private var binding: ActivityLaunchBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        sleep{
            startActivity<MainActivity>(this)
        }
    }

    fun sleep(block:()->Unit){
        object : Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message) {
                block()
            }
        }.sendEmptyMessageDelayed(1,3000)
    }


    override fun onDestroy() {
        super.onDestroy()
    }
}