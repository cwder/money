package com.cwd.money.act.page

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.work.*
import com.cwd.money.act.BaseActivity
import com.cwd.money.core.arch.DeltaWorker
import com.cwd.money.core.arch.DeltaWorkerMgr
import com.cwd.money.utils.log
import com.cwd.money.utils.toast
import com.cwd.money.vm.DeltaViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun DeltaScreen(){

    val vm:DeltaViewModel = viewModel()

    val ctx = LocalContext.current
    val state = DeltaWorkerMgr.getState(ctx,100).observeAsState()

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
                Button(onClick = {
                    state.value?.state?.log()
                    state.value?.state?.toast(ctx)
                },modifier = Modifier
                    .height(50.dp)
                    .wrapContentWidth(),
                ) {
                    Text(text = "查看状态")
                }
            }
            Row(
                modifier = Modifier.padding(5.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ){
                Button(onClick = {
                    state.value?.state?.log()
                    scope.launch {
                        if(state.value?.state != WorkInfo.State.RUNNING){
                            vm.getDeltaInfo().collect {
                                it.forEach {
                                    it.log()
                                }
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