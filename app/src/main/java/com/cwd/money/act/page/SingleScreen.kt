package com.cwd.money.act.page

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cwd.money.R
import com.cwd.money.request.bean.ShareRequest
import com.cwd.money.utils.toast
import com.cwd.money.vm.ShareViewModel


@Composable
fun SingleScreen(){
    val viewModel: ShareViewModel = viewModel()
    val ctx =LocalContext.current
    MaterialTheme{
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(30.dp,Alignment.Top)
        ) {
            SearchBar(viewModel,ShareRequest(""))

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


@Composable
fun SearchBar(viewModel: ShareViewModel,request: ShareRequest){

    val shareType = mutableMapOf<String,String>("沪指" to "sh","深指" to "sz")
    var selectedTag by remember { mutableStateOf("Null") }
    var inputText by remember{mutableStateOf("")}

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
        .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
        ){
        Row(verticalAlignment = Alignment.CenterVertically){
            shareType.forEach{
                Column(modifier = Modifier.padding(5.dp),horizontalAlignment =  Alignment.CenterHorizontally) {
                    RadioButton(
                        selected = it.value == selectedTag,           //是否选中
                        onClick = {
                            selectedTag = it.value
                        },                                          //点击事件
                        modifier=Modifier.padding(2.dp),            //修饰符
                        enabled=true,                               //是否启用
                        colors= RadioButtonDefaults.colors(
                            selectedColor= colorResource(R.color.red_color),                 //选中的颜色
                            unselectedColor = colorResource(R.color.black),              //未选中的颜色
                            disabledColor= colorResource(R.color.green_color_71c31f)                   //禁用的颜色
                        )
                    )
                    Text(text = it.key,textAlign = TextAlign.Center)
                }

            }
        }
        Spacer(modifier = Modifier.width(10.dp))
        OutlinedTextField(
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Default
            ),
            modifier = Modifier.weight(3f),
            value = inputText,
            onValueChange = {
                inputText = if (it.length <=6 )  it else it.substring(0,6)
            },
            label={ Text(text = "股票代码")},
            textStyle = TextStyle(
                color = colorResource(R.color.red_color),
                fontSize=15.sp
            ),
            singleLine = true
        )
        Spacer(modifier = Modifier.width(10.dp))
        Button(
            onClick={
                request.code = selectedTag + inputText
                viewModel.reqGetShare(request.code)
            },
            modifier = Modifier.weight(1f),
            content = {Text("搜索")}

        )
    }
}

