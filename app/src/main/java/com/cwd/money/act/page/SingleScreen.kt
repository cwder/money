package com.cwd.money.act.page

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cwd.money.utils.MysqlHelper
import com.cwd.money.utils.toast
import com.cwd.money.R
val list = listOf<String>("delta","delta","delta")

@Composable
fun SingleScreen(){
    val nRows = list.size % 3 + 1
    val nColumns = 3
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        // 显示列表
        items(nRows) { index ->
           Row(modifier = Modifier
               .fillMaxWidth(),
               horizontalArrangement = Arrangement.SpaceEvenly
           ) {
               Item()
           }
        }
    }
}

@Composable
fun Item(){
    Column(
        modifier = Modifier.size(100.dp).clickable(onClick = {
            delta()
        }),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_ac_unit_75),
            contentDescription = null,
            modifier = Modifier.size(50.dp,50.dp)
            )
        Text(text = "delta算法")
    }
}

fun delta(){
    Log.e("aaa","aaa---")
    print("aaa")
    MysqlHelper.begin()
}
@Preview
@Composable
fun Preview() {
    SingleScreen()
}




