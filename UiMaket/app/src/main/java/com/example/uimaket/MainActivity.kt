package com.example.uimaket

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.defaultDecayAnimationSpec
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.Row


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uimaket.ui.theme.UiMaketTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.uimaket.data.getCars
import kotlinx.coroutines.delay
import java.util.Timer
import java.util.TimerTask

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UiMaketTheme {
                enableEdgeToEdge()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    //val imageBitmap: Bitmap = BitmapFactory.decodeResource(LocalContext.current.resources, R.drawable.ic_launcher_background)
    var index by remember { mutableStateOf(4) }
    val cars = getCars()

    if (index == 5){
        index = 0
    }
    LaunchedEffect(Unit) {
        while (true) {
            delay(10000) // Ожидание 2 секунды
            index = (index + 1) % 5 // Обновление переменной index
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(cars[index].backColor)
    ) {

        Column(Modifier.fillMaxSize()) {


        Image(
            painter = painterResource(id = cars[index].bigPicture),
            contentDescription = "rar",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f),
            contentScale = ContentScale.Crop
        )
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),){
            Box(
                modifier = Modifier
                    .layoutId("content")
                    .clip(CutCornerShape(topStart = 400f))
                    .background(Color.LightGray)
            )
            Box(
                modifier = Modifier
                    .layoutId("box1")
                    .background(Color.Green)
            )
            Text(
                text = "Make it Easy",
                fontSize = 18.sp,
                modifier = Modifier.layoutId("title")
            )
            Box(
                modifier = Modifier
                    .layoutId("circle")
                    .clip(CircleShape)
                    .background(Color.Red)
            )
        }
        }
        Box(modifier = Modifier.fillMaxSize()){
            TopAppBar( colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Transparent),
                title = {  },
                        navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description",
                            tint = Color.White

                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description",
                            tint = Color.White
                        )
                    }
                },)

            Description(color = cars[index].backColor, brandName = cars[index].nameBrand, descriptionActor =  cars[index].description, brandPicture = cars[index].brandPicture )
        }

    }


}


@Composable
fun Description(color: Color, brandName: String, descriptionActor: String, brandPicture: Int){

    Box(Modifier.fillMaxSize()) {


    Box(modifier = Modifier

        .fillMaxWidth()
        .fillMaxHeight(0.4f)
        .align(Alignment.BottomCenter)) {

            Column {
                Spacer(modifier = Modifier.fillMaxHeight(0.15f))
                Box(modifier = Modifier
                    .background(color)
                    .fillMaxSize()
                    .padding(horizontal = 12.dp)){
                    Column {
                        Spacer(modifier = Modifier.weight(1f))
                        Row(modifier = Modifier.weight(2f), verticalAlignment = Alignment.CenterVertically) {
                            Image(modifier = Modifier
                                .clip(shape = CircleShape)
                                .size(48.dp),painter = painterResource(id = brandPicture), contentDescription = "icon actor",
                                contentScale = ContentScale.Crop)
                            Spacer(modifier = Modifier.width(20.dp))
                            Column {
                                Text(text = brandName, color = Color.White ,)
                                Text(text = "6 Days Ago", color = Color.Gray, fontSize = 14.sp)
                                
                            }
                            Spacer(modifier = Modifier.weight(1f))

                            val colorStops = arrayOf(
                                0.1f to Color(0xFFF76A1F),
                                0.9f to Color(0xFFFA6160),

                            )
                            Button(onClick = { /*TODO*/ }, modifier = Modifier.background(
                                Brush.horizontalGradient(colorStops =  colorStops),
                                shape = ButtonDefaults.shape
                            ),
                                colors = ButtonDefaults.buttonColors(Color.Transparent)


                            ) {
                                Text(text = "+ Follow", color = Color.White)
                            }
                        }
                        Box(
                            Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                                .background(Color.Gray))
                        Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Recommended by :" , color = Color.Gray)
                            Spacer(modifier = Modifier.weight(1f))
                            Text(text = "18 / 56 users",  color = Color.Gray)
                        }
                        Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                            Row {

                                Image(
                                    painter = painterResource(id = R.drawable.brad),  contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(30.dp)
                                        .clip(CircleShape)
                                )
                                Image(painter = painterResource(id = R.drawable.edwardnorton),  contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(30.dp)

                                        .graphicsLayer {
                                            shape = CircleShape
                                            clip = true
                                            translationX = (-18).dp.toPx()
                                        }
                                        )
                                Image(painter = painterResource(id = R.drawable.dep),  contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(30.dp)

                                        .graphicsLayer {
                                            shape = CircleShape
                                            clip = true
                                            translationX = (-36).dp.toPx()
                                        }
                                )
                                Image(painter = painterResource(id = R.drawable.charlize),  contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(30.dp)

                                        .graphicsLayer {
                                            shape = CircleShape
                                            clip = true
                                            translationX = (-18 * 3).dp.toPx()
                                        }
                                )
                                Box(
                                    modifier = Modifier
                                        .size(30.dp)

                                        .graphicsLayer {
                                            clip = true
                                            shape = CircleShape
                                            translationX = (-18 * 3 - 10).dp.toPx()
                                        }
                                        .background(Color(0x46B8B8B8))

                                ){
                                    Text(
                                        "+ 36",
                                        style = TextStyle(color = Color.White, fontSize = 12.sp),
                                        modifier = Modifier.align(Alignment.Center)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.weight(1f))
                            Row(Modifier.padding(4.dp), verticalAlignment = Alignment.CenterVertically) {
                                Icon(painterResource(id = R.drawable.outline_explore_24) , null , tint = Color.Gray)
                                Text(text = "2.615", color = Color.White )
                                Spacer(modifier = Modifier.width(10.dp))
                                Icon(painterResource(R.drawable.baseline_chat_bubble_24), null , tint = Color.Gray)
                                Text(text = "368", color = Color.White)
                                Spacer(modifier = Modifier.width(10.dp))
                                Icon(painterResource(R.drawable.baseline_favorite_24), null , tint = Color.Gray)
                                Text(text = "991", color = Color.White)
                            }
                        }

                    }
                }
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
                .padding(horizontal = 12.dp)
                ){
                Text(text = descriptionActor, color = Color.White, fontSize = 20.sp,
                    fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif, modifier = Modifier)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UiMaketTheme {
        Greeting("Android")
    }
}

