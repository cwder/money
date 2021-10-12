package com.cwd.money.act

import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import com.cwd.money.R
import com.cwd.money.databinding.ActivityLaunchBinding
import com.cwd.money.utils.Util


class LaunchActivity : AppCompatActivity() {

    private var binding:ActivityLaunchBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        //生命周期
        binding?.myView?.let { lifecycle.addObserver(it) }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}