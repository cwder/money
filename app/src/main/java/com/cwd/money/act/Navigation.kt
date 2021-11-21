package com.cwd.money.act

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cwd.money.act.page.TabScreen

enum class PageScreen {
    TabScreen
}

@Composable
fun ComposeNavigation(){
    PageNavHost()
}

@Composable
fun PageNavHost(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = PageScreen.TabScreen.name
    ) {
        composable(PageScreen.TabScreen.name) {
            TabScreen()
        }

    }
}