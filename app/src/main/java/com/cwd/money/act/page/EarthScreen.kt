package com.cwd.money.act.page

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
@SuppressLint("UnrememberedMutableState")
@Composable
fun EarthScreen(){
    Text("EarthScreen")
    var count by mutableStateOf(0)
    Surface() {

        //var count = 0 // 无情况
        //var count by mutableStateOf(0)
        Button(
            onClick = { count++ }, modifier = Modifier
                .padding(count.dp)
                .fillMaxWidth()
                .height(50.dp)
        ) {

            Text(
                text = "I have been clicked $count times",
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            SideEffect(effect = { Log.e("aaa","---- text count = $count ") })
        }
        Text(text = "aa")
        SideEffect(effect = { Log.e("aaa","---- out count = $count ") })
    }


}