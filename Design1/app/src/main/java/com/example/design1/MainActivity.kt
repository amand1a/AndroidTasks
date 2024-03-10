package com.example.design1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import com.example.design1.ui.theme.Design1Theme
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Design1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FourthTask()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    Box(modifier = Modifier.fillMaxSize()){
        Box( modifier = Modifier
            .padding(4.dp)
            .wrapContentSize()
            .align(Alignment.Center)
            .border(1.dp, Color.Gray, RectangleShape),
            contentAlignment = Alignment.Center){

            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)){
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color(0xFF9C27B0))){

            }
                Spacer(modifier = Modifier.height(20.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.Red)){

            }
                Spacer(modifier = Modifier.height(20.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.Yellow)){

            }
                Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { /*TODO*/ }, modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .background(Color.Green),
                shape = RectangleShape) {
                Text(text = "Button", color = Color.White)
            }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Design1Theme {
        Greeting("Android")
    }
}