package com.cwd.money.act

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf

class MainActivity : BaseActivity() {
    private val screenName = mutableStateOf(PageScreen.TabScreen)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigation()
        }
    }
}

