package com.cwd.money.act

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.compose.runtime.Composable
import com.cwd.money.databinding.ActivityLaunchBinding
import com.cwd.money.utils.startActivity
import androidx.compose.material.*
class LaunchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLaunchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.composeView.apply {
            setContent {
                MaterialTheme {
                    Text("Hello Compose!")
                }
            }
        }
//        binding.root?.composeView?.setContent {
//            title()
//        }

    }

    @Composable
    fun title(){
        Text("aa")
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
}