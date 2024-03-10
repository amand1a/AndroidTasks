package com.example.customview

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.StyleRes
import androidx.constraintlayout.widget.ConstraintAttribute
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.toColor
import com.example.customview.databinding.CustomViewBinding
import java.util.zip.Inflater

class CustomView( context: Context , attrs: AttributeSet? , defStyleAttr: Int , defStyleRes: Int
): ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {
    private val listOfColor = listOf(
        Color.argb(255, 255, 0, 0),    // Красный
        Color.argb(255, 0, 255, 0),    // Зеленый
        Color.argb(255, 0, 0, 255),    // Синий
        Color.argb(255, 255, 255, 0),  // Желтый
        Color.argb(255, 255, 0, 255),  // Фиолетовый
        Color.argb(255, 0, 255, 255),  // Голубой
        Color.argb(255, 255, 128, 0),  // Оранжевый
        Color.argb(255, 128, 0, 255),  // Фиолетовый
        Color.argb(255, 0, 128, 128),  // Темно-голубой
        Color.argb(255, 128, 128, 128) // Серый
    )
    private val binding: CustomViewBinding
    private var indexOfColor = 0

    constructor(context: Context , attrs: AttributeSet? , defStyleAttr: Int ): this(context, attrs, defStyleAttr , defStyleRes = 0)
    constructor(context: Context , attrs: AttributeSet? ): this(context , attrs , 0)
    constructor(context: Context): this(context , null)


    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.custom_view , this , true)
        binding = CustomViewBinding.bind(this)
        initializedAttributes(attrs, defStyleAttr, defStyleRes)
        init()
    }


    private fun initializedAttributes(attrs: AttributeSet? , defStyleAttr: Int , defStyleRes: Int){

        if(attrs  == null){
            return
        }

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomView , defStyleAttr , defStyleRes)
        binding.apply {
            val color = typedArray.getColor(R.styleable.CustomView_backgroundColorUnderButton , Color.GRAY)
            linear1.setBackgroundColor(color)

        }
        typedArray.recycle()
    }
    public fun adwd(){

    }

    @OptIn(ExperimentalStdlibApi::class)
    private fun init(){
        binding.apply {
            viewForChangeColor.setBackgroundColor(listOfColor[indexOfColor])
            textView2.text = listOfColor[indexOfColor].toHexString(format = HexFormat.UpperCase)
            buttonNext.setOnClickListener {
                indexOfColor++
                if(indexOfColor > 9) indexOfColor = 0
                viewForChangeColor.setBackgroundColor(listOfColor[indexOfColor])




            }
            buttonPrev.setOnClickListener {
                indexOfColor--
                if(indexOfColor < 0) indexOfColor = 9
                viewForChangeColor.setBackgroundColor(listOfColor[indexOfColor])
                textView2.text = listOfColor[indexOfColor].toHexString(format = HexFormat.UpperCase)
            }
        }
    }



}