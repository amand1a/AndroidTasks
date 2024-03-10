package com.example.design1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ThirdTask(modifier: Modifier = Modifier){
    Box(modifier = Modifier.fillMaxSize()){
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier
                .fillMaxHeight(0.5f).weight(1f)
                .background(Color.Yellow))
            Box(modifier = Modifier
                .fillMaxHeight(0.85f).weight(2f)
                .background(Color.Red))
            Box(modifier = Modifier
                .fillMaxHeight(0.8f).weight(1f)
                .background(Color.Cyan) )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewThirdTask(){
    ThirdTask()
}