package com.example.uimaket.data

import androidx.compose.ui.graphics.Color
import com.example.uimaket.R

data class Cars(
    val nameBrand: String,
    val bigPicture: Int,
    val brandPicture: Int,
    val description: String,
    val backColor: Color,
)


fun getCars(): Array<Cars>{
    return arrayOf(
        Cars("Porsche", R.drawable.porshe911, R.drawable.porsheeblem,"RWB has combined Japanese and Euro tuning elements, creating the RWB style for Porsche chassis.", Color(0xFF1C241D) ),
        Cars( "BMW", R.drawable.bmwm5f90, R.drawable.bmwlogo,"BMW M5 Competition has taken an iconic design language and accentuated it with eye-catching elements.", Color(
            0xFF253C4B
        )
        ),
        Cars("Porsche",
            R.drawable.porchegt3rs, R.drawable.porsheeblem,"The performance of the new 911 GT3 RS has been raised to levels which make it an aerodynamic wonder.", Color(
                0xFF5A3344
            )
        ),
        Cars("Porsche",
            R.drawable._18, R.drawable.porsheeblem,"The 918 Spyder embodies the essence of the Porsche idea: it combines pedigree motor racing technology with excellent everyday utility.", Color(
                0xFF202D38
            )
        ),
        Cars("Mercedes Benz",
            R.drawable.e63,
            R.drawable.merslogo,"The E 63 S might be the most irrational, irresistible sedan ever. Or the most practical, versatile supercar on earth.", Color(
                0xFF33322E
            )
        )
    )
}