package com.example.pr23kargin

import android.content.Context
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.GestureDetector.OnGestureListener
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat
import kotlin.math.roundToInt

open class GestureProcessing : AppCompatActivity(), OnGestureListener {
    private lateinit var GDC : GestureDetectorCompat
    private lateinit var refContext: Context
    fun defineGDC(context: Context){
        refContext = context
        GDC = GestureDetectorCompat(context, this)
    }

    open fun onSwipeLeft(){

    }
    open fun onSwipeRight(){

    }

    final override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (GDC.onTouchEvent(event)) {
            true
        } else {
            super.onTouchEvent(event)
        }
    }


    final override fun onDown(e: MotionEvent?): Boolean {
        return true
    }

    final  override fun onShowPress(e: MotionEvent?) {
    }

    final  override fun onSingleTapUp(e: MotionEvent?): Boolean {
        return true
    }

    final  override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
       return true
    }

    final  override fun onLongPress(e: MotionEvent?) {
    }

    final  override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        val valueX1 : Int = e1!!.x.roundToInt()
        val valueX2 : Int = e2!!.x.roundToInt()
        val generalX = valueX2 - valueX1
        if (generalX > 100 ) onSwipeRight()
        else if (generalX < -100 ) onSwipeLeft()
        return true
    }


}