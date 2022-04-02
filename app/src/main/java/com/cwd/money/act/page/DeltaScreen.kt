package com.cwd.money.act.page

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.cwd.money.core.arch.DeltaWorker
import com.cwd.money.utils.log

@Composable
fun DeltaScreen(){
    val ctx = LocalContext.current
    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),horizontalArrangement = Arrangement.Center){
            Text(text = "低部股价，换手率高")
        }
        Row(modifier = Modifier
            .fillMaxWidth()) {
            Row(
                modifier = Modifier.padding(5.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ){
                Button(onClick = {
                    doWork(ctx)
                },modifier = Modifier
                    .height(50.dp)
                    .width(200.dp),
                ) {
                    Text(text = "启动插入任务")
                }
            }
            Row(
                modifier = Modifier.padding(5.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ){
                Button(onClick = { /*TODO*/ },modifier = Modifier
                    .height(50.dp)
                    .width(200.dp),
                ) {
                    Text(text = "更新数据")
                }
            }
        }


    }
}

fun doWork(ctx:Context){
    "begin".log()
    val data = Data.Builder().putInt("bLine",100).build()
    val delatRequest: WorkRequest = OneTimeWorkRequestBuilder<DeltaWorker>()
        .setInputData(data)
        .build()
    val workManager: WorkManager = WorkManager.getInstance(ctx)
    workManager.enqueue(delatRequest)
}