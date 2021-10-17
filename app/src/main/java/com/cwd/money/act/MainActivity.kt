package com.cwd.money.act

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.commit
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.cwd.money.R
import com.cwd.money.databinding.ActivityMainBinding
import com.cwd.money.fragment.LaunchFragment
import com.cwd.money.utils.Util
import com.cwd.money.utils.toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initView()
    }

    fun initView() {
        val bottomMenu = binding?.bottomMenu
        val fragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val navController = fragment.navController
        bottomMenu?.setupWithNavController(navController)

    }



    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}