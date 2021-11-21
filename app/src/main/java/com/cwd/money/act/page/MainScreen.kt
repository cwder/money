package com.cwd.money.act.page

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cwd.money.R

sealed class Screen(val route: String, @StringRes val resourceId: Int,val defImages:Int,val selectImages:Int) {
    object SingleScreen : Screen("SingleScreen", R.string.single,R.mipmap.baseline_single_new_white_24,R.mipmap.baseline_single_new_black_24)
    object EarthScreen : Screen("EarthScreen", R.string.earth,R.mipmap.baseline_earth_white_24,R.mipmap.baseline_earth_black_24)
    object FavoriteScreen : Screen("FavoriteScreen", R.string.favorite,R.mipmap.baseline_favorite_border_white_24,R.mipmap.baseline_favorite_border_black_24)
    object HomeScreen : Screen("HomeScreen", R.string.home,R.mipmap.baseline_home_white_24,R.mipmap.baseline_home_black_24)

}


private val labels = arrayOf("单股", "精选", "全球", "我的")
val items = listOf(
    Screen.SingleScreen,
    Screen.EarthScreen,
    Screen.FavoriteScreen,
    Screen.HomeScreen
)

//导航默认图标集合
private val defImages =
    arrayOf(R.mipmap.baseline_single_new_white_24,
        R.mipmap.baseline_favorite_border_white_24,
        R.mipmap.baseline_earth_white_24,
        R.mipmap.baseline_home_white_24
    )

//导航选中图标集合
private var selectImages =
    arrayOf(
        R.mipmap.baseline_single_new_black_24,
        R.mipmap.baseline_favorite_border_black_24,
        R.mipmap.baseline_earth_black_24,
        R.mipmap.baseline_home_black_24
    )


@Composable
fun TabScreen(navHostController: NavHostController) {
    //导航选中索引
    val selectIndex = remember {
        mutableStateOf(0)
    }
    Scaffold(
        //设置底部导航栏
        bottomBar = {
                BottomNavigation() {
                    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination

                    items.forEachIndexed { index,screen ->
                        BottomNavigationItem(
                            label = {Text(stringResource(screen.resourceId))},
                            selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true ,
                            onClick = {
                                selectIndex.value = index
                            },
                            icon = {
                                when(index){
                                    selectIndex.value -> {
                                        Image(painter = painterResource(id = screen.selectImages), contentDescription = null)
                                    }
                                    else -> {
                                        Image(painter = painterResource(id = screen.defImages), contentDescription = null)
                                    }
                                }
                            }
                        )
                    }
                }
            },

    ) {
        //设置页面主内容区域，这里通过NavHost，根据选中不同的导航栏Tab导航到不同的页面。
        NavHost(navController = navHostController, startDestination = Screen.SingleScreen.route) {
            composable(Screen.SingleScreen.route) {
                SingleScreen()
            }
            composable(Screen.FavoriteScreen.route) {
                FavoriteScreen()
            }
            composable(Screen.EarthScreen.route) {
                EarthScreen()
            }
            composable(Screen.HomeScreen.route) {
                HomeScreen()
            }
        }
    }
}