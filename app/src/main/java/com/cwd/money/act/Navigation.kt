package com.cwd.money.act

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cwd.money.R
import com.cwd.money.act.page.TopScreen

enum class PageScreen {
    TabScreen
}

sealed class TabScreen(val route: String, @StringRes val resourceId: Int, val defImages:Int, val selectImages:Int) {
    object SingleScreen : TabScreen("SingleScreen", R.string.single,
        R.mipmap.baseline_single_new_white_24,
        R.mipmap.baseline_single_new_black_24)
    object EarthScreen : TabScreen("EarthScreen", R.string.earth, R.mipmap.baseline_earth_white_24, R.mipmap.baseline_earth_black_24)
    object FavoriteScreen : TabScreen("FavoriteScreen", R.string.favorite,
        R.mipmap.baseline_favorite_border_white_24,
        R.mipmap.baseline_favorite_border_black_24)
    object HomeScreen : TabScreen("HomeScreen", R.string.home, R.mipmap.baseline_home_white_24, R.mipmap.baseline_home_black_24)

}

sealed class Screen(val route:String){
    object DeltaPage:Screen("DeltaScreen")
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
            TopScreen()
        }

    }
}