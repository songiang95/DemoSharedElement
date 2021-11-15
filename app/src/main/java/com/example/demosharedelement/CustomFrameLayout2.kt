package com.example.demosharedelement

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.FrameLayout

class CustomFrameLayout2(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {



    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Log.d("taih", "onDraw22222")
    }

    override fun drawChild(canvas: Canvas?, child: View?, drawingTime: Long): Boolean {
        return super.drawChild(canvas, child, drawingTime)

    }
}