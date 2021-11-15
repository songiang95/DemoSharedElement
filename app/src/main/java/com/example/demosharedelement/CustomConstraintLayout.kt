package com.example.demosharedelement

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout

class CustomConstraintLayout(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Log.d("taih", "onDraw: ")
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        Log.d("taih", "draw")
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }
}