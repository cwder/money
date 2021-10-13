package com.cwd.money.act

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.cwd.money.R
import com.cwd.money.databinding.ActivityMainBinding
import com.cwd.money.fragment.LaunchFragment
import com.cwd.money.utils.Util

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initF()
    }

    fun initF(){
       supportFragmentManager.commit {
           add(R.id.fragment,LaunchFragment())
       }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}