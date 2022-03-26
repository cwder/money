package com.cwd.money.act.page


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cwd.money.act.MainActivity
import com.cwd.money.vm.TableViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


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
    val ctx = LocalContext.current as MainActivity
    val vm: TableViewModel = viewModel()
    Column(
        modifier = Modifier
            .size(100.dp)
            .clickable(onClick = {

            }),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Image(
            painter = painterResource(id = com.cwd.money.R.drawable.ic_baseline_ac_unit_75),
            contentDescription = null,
            modifier = Modifier.size(50.dp,50.dp)
            )
        Text(text = "delta算法",modifier =
        Modifier.clickable(onClick = {
        }))
    }
}

fun test(){
   runBlocking {
       val one = async {

       }
   }
}

suspend fun testS():String{
    delay(500)
    return "testS"
}

//fun delta(){
//
//    val vm: TableViewModel = viewModel()
//    val sql = "show tables"
//    //MysqlHelper.test()
//    //val job: kotlinx.coroutines.Job= MysqlHelper.begin(sql)
//    //val res = job.wait()
//}

@Preview
@Composable
fun Preview() {
    SingleScreen()
}




