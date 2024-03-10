package com.example.design1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.aspectRatio
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
fun FourthTask(){
    Box(modifier = Modifier.fillMaxSize()){
        Box(
            Modifier
                .fillMaxWidth(0.8f)
                .aspectRatio(1f)
                .background(Color.Red),){
            Box(
                Modifier
                    .fillMaxWidth(0.15f)
                    .aspectRatio(1f)
                    .align(Alignment.BottomStart)
                    .background(Color(0xFF84BBD0)))
            Box(modifier = Modifier
                .fillMaxWidth(0.15f)
                .aspectRatio(1f)
                .align(Alignment.TopStart)
                .background(Color(0xFF99CC00)))
            Box(modifier = Modifier.fillMaxWidth(0.15f).aspectRatio(1f).align(Alignment.Center).background(Color(0xFFA966CB)))
            Box(modifier = Modifier
                .fillMaxWidth(0.15f)
                .aspectRatio(1f)
                .align(Alignment.TopEnd)
                .background(Color.Black)){
                Box(modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .aspectRatio(1f)
                    .align(Alignment.TopEnd)
                    .background(Color(0xFFFA8903)))
            }
        }
    }
}

@Preview
@Composable
fun PreviewFourthTask(){
    FourthTask()
}