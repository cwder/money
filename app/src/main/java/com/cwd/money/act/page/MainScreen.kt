package com.cwd.money.act.page

import androidx.compose.foundation.Image
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cwd.money.act.Screen
import com.cwd.money.act.TabScreen


val items = listOf(
    TabScreen.SingleScreen,
    TabScreen.EarthScreen,
    TabScreen.FavoriteScreen,
    TabScreen.HomeScreen
)

@Composable
fun TopScreen() {
    //导航选中索引
    val selectIndex = remember {
        mutableStateOf(0)
    }
    //只能放这，从外面传进来就报错
    val navHostController = rememberNavController()
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
                                navHostController.navigate(screen.route) {
                                    // Pop up to the start destination of the graph to
                                    // avoid building up a large stack of destinations
                                    // on the back stack as users select items
                                    popUpTo = navHostController.graph.startDestinationId
                                    // Avoid multiple copies of the same destination when
                                    // reselecting the same item
                                    launchSingleTop = true
                                }
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
        NavHost(navController = navHostController, startDestination = TabScreen.SingleScreen.route) {
            composable(TabScreen.SingleScreen.route) {
                SingleScreen(navHostController)
            }
            composable(TabScreen.FavoriteScreen.route) {
                FavoriteScreen()
            }
            composable(TabScreen.EarthScreen.route) {
                EarthScreen()
            }
            composable(TabScreen.HomeScreen.route) {
                HomeScreen()
            }
            composable(Screen.DeltaPage.route) {
                DeltaScreen()
            }
        }
    }
}

@Preview
@Composable
fun aaab() {
    //PageScreen.TabScreen()
}