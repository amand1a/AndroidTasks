package com.example.customview

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CustomProgressBar(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int ) : View(context, attrs, defStyleAttr, defStyleRes) {

     public var value: Float?  = null
        set(value) {
            field = value
            val animator = ValueAnimator.ofFloat(0f, value ?: 0f)
            val sec = 1000 *((value ?: 0f)/100)
            animator.setDuration( sec.toLong() )
            animator.addUpdateListener { animation -> field = animation.animatedValue as Float
                invalidate()}
            animator.start()

        }

    private var sizeOfSquare = 0f
    private val sizeOfSmallCircle = 30f
    private val sizeOfBigCircle = 50f
    private val radiusOfSmallCircle: Float
        get() = sizeOfSquare / 2 - (sizeOfBigCircle - sizeOfSmallCircle) / 2 - sizeOfSmallCircle / 2

    private val radiusOfBigCircle: Float
        get() = sizeOfSquare / 2 - sizeOfBigCircle / 2
    private lateinit var firstSircle: Paint
    private lateinit var secondSircle: Paint
    private lateinit var textPaint: Paint


    constructor(context: Context , attrs: AttributeSet? , defStyleAttr: Int ): this(context, attrs, defStyleAttr , defStyleRes = 0)
    constructor(context: Context , attrs: AttributeSet? ): this(context , attrs , 0)
    constructor(context: Context): this(context , null)

    init {

        if(attrs != null){
            initAttributes(attrs, defStyleAttr, defStyleRes)
        }
        initPaints()
    }



    private fun initAttributes(attrs: AttributeSet? , defStyleAttr: Int, defStyleRes: Int){
        val typedArray =  context.obtainStyledAttributes(attrs , R.styleable.CustomProgressBar ,0 , 0)
        value = typedArray.getInt(R.styleable.CustomProgressBar_value , 50).toFloat()
        typedArray.recycle()

    }

    private fun initPaints(){
        firstSircle = Paint(Paint.ANTI_ALIAS_FLAG)
        firstSircle.apply {
            color = Color.argb(255, 154, 195, 200)
            strokeWidth = 30f
            style = Paint.Style.STROKE

        }

        secondSircle= Paint(Paint.ANTI_ALIAS_FLAG)
        secondSircle.apply {
            color = Color.argb(255 ,48 ,137 ,145)
            strokeWidth = 50f
            style = Paint.Style.STROKE
        }

        textPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        textPaint.apply {
            textAlign = Paint.Align.CENTER
            color = Color.BLACK
            textSize = 50f
        }

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawSmallCircle(canvas)
        drawBigCircle(canvas)
        drawText(canvas)
    }

    private fun drawSmallCircle(canvas: Canvas) {
        canvas.drawCircle(
            sizeOfSquare / 2,
            sizeOfSquare / 2,
            radiusOfSmallCircle,
            firstSircle
        )

    }

    private fun drawBigCircle(canvas: Canvas) {
        val startAngle = 270f // Начальный угол в градусах (12 часов)
        val sweepAngle =  if (value != null) 3.6f * value!! else 0f


        canvas.drawArc(
            (sizeOfSquare / 2 - radiusOfBigCircle),
            (sizeOfSquare / 2 - radiusOfBigCircle),
            (sizeOfSquare / 2 + radiusOfBigCircle),
            (sizeOfSquare / 2 + radiusOfBigCircle),
            startAngle,
            sweepAngle,
            false,
            secondSircle
        )
    }

    private fun drawText(canvas: Canvas){
        canvas.drawText(value.toString() , sizeOfSquare/2 , sizeOfSquare/2+(26f/2) ,textPaint)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        sizeOfSquare = minOf(w , h).toFloat()

    }

    public fun setValue(num: Float){
        value = num
    }





}