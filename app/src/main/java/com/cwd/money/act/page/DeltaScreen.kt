package com.cwd.money.act.page

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
@Composable
fun DeltaScreen(){
    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Row(modifier = Modifier.fillMaxWidth().padding(10.dp),horizontalArrangement = Arrangement.Center){
            Text(text = "低部股价，换手率高")
        }
        Row(modifier = Modifier.fillMaxWidth().padding(10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
            ){
            Button(onClick = { /*TODO*/ },modifier = Modifier
                .height(50.dp).width(200.dp),
            ) {
                Text(text = "启动插入任务")
            }
        }
        Row(modifier = Modifier.fillMaxWidth().padding(10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
            ){
            Button(onClick = { /*TODO*/ },modifier = Modifier
                .height(50.dp).width(200.dp),
            ) {
                Text(text = "更新数据")
            }
        }
    }
}