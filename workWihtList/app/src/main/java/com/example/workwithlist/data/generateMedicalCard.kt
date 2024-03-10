package com.example.workwithlist.data

import android.graphics.Color

fun generateMedicalCard(): ArrayList<MedicalCard>{
    val medicalCards = arrayListOf<MedicalCard>()
    val type = "therapy plan"

    val colors = listOf(
        Color.RED,
        Color.BLUE,
        Color.GREEN,
        Color.YELLOW,
        Color.argb(255, 200, 100, 100),
        Color.CYAN,
        Color.MAGENTA,
        Color.DKGRAY,
        Color.LTGRAY,
        Color.argb(255, 200, 170, 100),
        Color.WHITE,
        Color.GRAY,
        Color.rgb(255, 165, 0), // Orange
        Color.rgb(128, 0, 128), // Purple
        Color.rgb(0, 128, 0), // Dark Green
        Color.rgb(255, 192, 203), // Pink
        Color.rgb(0, 0, 128), // Navy
        Color.rgb(128, 0, 0), // Maroon
        Color.rgb(0, 128, 128), // Teal
        Color.rgb(255, 255, 0) // Yellow
    )

    for (i in 1..20) {
        val color = colors[i-1]
        val medicalCard = MedicalCard(type, color)
        medicalCards.add(medicalCard)
    }

    return medicalCards
}