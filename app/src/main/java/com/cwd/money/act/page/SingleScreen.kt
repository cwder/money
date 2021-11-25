package com.cwd.money.act.page

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SingleScreen(){
    MaterialTheme{
        Column(
            modifier = Modifier.fillMaxSize().padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Row{
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