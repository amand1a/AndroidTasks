package com.example.design1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable

fun SecondTask (modifier: Modifier = Modifier){
    val scrollState = rememberScrollState()
    Box(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)){
        Column(modifier = Modifier.wrapContentSize()) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Red))
            Spacer(modifier = Modifier.height(280.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .background(Color.Yellow))
            Spacer(modifier = Modifier.height(100.dp))

            Button(onClick = { /*TODO*/ } , modifier = Modifier
                .fillMaxWidth()
                .height(40.dp), shape = RectangleShape) {
                Text(text = "Button", color = Color.White)
            }

        }
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewSecondTask(){
    SecondTask()
}