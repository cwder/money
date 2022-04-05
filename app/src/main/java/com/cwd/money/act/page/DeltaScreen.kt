package com.cwd.money.act.page

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.cwd.money.act.BaseActivity
import com.cwd.money.core.arch.DeltaWorker
import com.cwd.money.core.arch.DeltaWorkerMgr
import com.cwd.money.utils.log
import com.cwd.money.vm.DeltaViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun DeltaScreen(){

    val vm:DeltaViewModel = viewModel()

    val ctx = LocalContext.current
    var txt by remember { mutableStateOf("init")}
    DeltaWorkerMgr.getState(ctx,50).apply {
        observe(ctx as BaseActivity,Observer {
                workStatus -> txt = workStatus.state.toString()
        } )
    }

    val scope = rememberCoroutineScope()
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
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
            ) {
            Row(
                modifier = Modifier.padding(5.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ){
                Button(onClick = {
                    DeltaWorkerMgr.begin(ctx as BaseActivity)
                },modifier = Modifier
                    .height(50.dp)
                    .wrapContentWidth(),
                ) {
                    Text(text = "启动插入任务")

                }
            }
            Row(
                modifier = Modifier.padding(5.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "$txt",modifier = Modifier
                    .height(50.dp)
                    .wrapContentWidth())
            }
            Row(
                modifier = Modifier.padding(5.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ){
                Button(onClick = {
                    scope.launch {
                        vm.getDeltaInfo().collect {
                            it.forEach {
                                it.log()
                            }
                        }
                    }
                },modifier = Modifier
                    .height(50.dp)
                    .wrapContentWidth(),
                ) {
                    Text(text = "更新数据")
                }
            }
        }


    }
}

fun doWork(ctx:Context){
    val data = Data.Builder().putInt("bLine",100).build()
    val delatRequest: WorkRequest = OneTimeWorkRequestBuilder<DeltaWorker>()
        .setInputData(data)
        .build()
    val workManager: WorkManager = WorkManager.getInstance(ctx)
    workManager.enqueue(delatRequest)
}