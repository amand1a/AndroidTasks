package com.example.observer

import android.os.Handler
import android.os.Looper
import java.sql.Time
import java.util.Timer
import java.util.TimerTask
import kotlin.random.Random

object WeatherObserver  {

    private val subscribers = mutableListOf<Subscriber>()

    var handler: Handler? = null
    fun addSubscriber(sub: Subscriber){
        subscribers.add(sub)
    }

    fun removeSubscriber(sub: Subscriber){
        subscribers.remove(sub)
    }

    private fun notifySubscriber(weather: Int){
        subscribers.map {sub ->

            handler?.let {
                it.post { sub.update(weather) }
            }

        }
    }


    init{
        val timer = Timer();
        val task = object : TimerTask(){
            override fun run() {
                notifySubscriber(getRandomWeather())
            }

        }

        timer.scheduleAtFixedRate(task  ,0L, 5000L )
    }

    private fun getRandomWeather(): Int{
        return  Random.nextInt(-10,30)
    }

}