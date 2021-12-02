package com.cwd.money.act.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cwd.money.R
import com.cwd.money.utils.toast
import com.cwd.money.vm.ShareViewModel

@Composable
fun SingleScreen(){
    val viewModel: ShareViewModel = viewModel()
    var inputText by remember{mutableStateOf("")}
    val res = viewModel.shareData.observeAsState()
    val ctx =LocalContext.current
    MaterialTheme{
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(30.dp,Alignment.Top)
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ){
                OutlinedTextField(
                    modifier = Modifier.weight(3f),
                    value = inputText,
                    onValueChange = {inputText=it},
                    label={ Text(text = "股票代码")},
                    textStyle = TextStyle(
                        color = colorResource(R.color.red_color),
                        fontSize=15.sp
                    ),
                )
                Spacer(modifier = Modifier.width(10.dp))
                Button(
                    onClick={
                        "aaa".toast(ctx)
                        viewModel.reqGetShare(inputText)
                    },
                    modifier = Modifier.weight(1f),
                    content = {Text("搜索")}

                )
            }

            Row{
                Text(text = "第一个文本控件ikkokokojih呼呼呼呼呼呼")
                Text(text = "   第二个文本控件")
            }

            Row{
                Text(text = "第一个文本控件ikkokokojih呼呼呼呼呼呼")
                Text(text = "   第二个文本控件")
            }

        }
    }
}