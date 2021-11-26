package com.cwd.money.act.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.cwd.money.R
@Composable
fun SingleScreen(){
    MaterialTheme{
        Column(
            modifier = Modifier.fillMaxSize().padding(top = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(30.dp,Alignment.Top)
        ) {
            Row(modifier = Modifier
                .padding(10.dp)
                .background(color = colorResource(R.color.red_color_b32f31))
                .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
            ){
                Text(text = "第一个文本控件ikkokokojih呼呼呼呼呼呼")
                Text(text = "   第二个文本控件")
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