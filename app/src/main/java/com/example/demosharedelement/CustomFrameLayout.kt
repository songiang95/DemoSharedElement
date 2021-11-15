package com.example.demosharedelement

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.FrameLayout

class CustomFrameLayout(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        Log.d("taih", "onLayout: ")
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        Log.d("taih", "onSizeChanged: ")
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Log.d("taih", "onDraw")
    }

    override fun getDrawingCache(): Bitmap {
        Log.d("taih", "getDrawingCache")
        return super.getDrawingCache()
    }

    override fun drawChild(canvas: Canvas?, child: View?, drawingTime: Long): Boolean {
        Log.d("taih", "drawChild")
        return super.drawChild(canvas, child, drawingTime)
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        Log.d("taih", "draw")
    }

    get






}