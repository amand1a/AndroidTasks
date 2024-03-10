package com.example.observer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView

class MainActivity  : AppCompatActivity() , Subscriber  {
    private val handler = Handler(Looper.getMainLooper())
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById<TextView>(R.id.textView)
        WeatherObserver.handler = handler
        WeatherObserver.addSubscriber(this)
    }

    override fun update(date: Int) {
        textView.text = date.toString()
    }


    override fun onDestroy() {
        super.onDestroy()
        WeatherObserver.removeSubscriber(this)
    }
}