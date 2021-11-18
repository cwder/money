package com.cwd.money.act

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import com.cwd.money.databinding.ActivityLaunchBinding
import com.cwd.money.utils.startActivity
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

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
            centerView()
        }
    }


    @Preview
    @Composable
    fun centerView(){
        Text("Hello Compose!")
        Text("aaaa")
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