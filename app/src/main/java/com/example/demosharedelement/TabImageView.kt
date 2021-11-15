package com.example.demosharedelement

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Matrix
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class TabImageView(context: Context, attrs: AttributeSet?) : AppCompatImageView(context, attrs) {
    private var imgWidth = 0
    private var imgHeight = 0

    //private val _matrix =
    override fun setImageBitmap(bm: Bitmap?) {
        super.setImageBitmap(bm)
        if (bm != null) {
            imgWidth = bm.width
            imgHeight = bm.height

        } else {
            imgWidth = 0
            imgHeight = 0
        }
        computeMatrix()
    }

    override fun setImageDrawable(drawable: Drawable?) {
        super.setImageDrawable(drawable)
        if (drawable != null) {
            imgWidth = drawable.intrinsicWidth
            imgHeight = drawable.intrinsicHeight
        } else {
            imgWidth = 0
            imgHeight = 0
        }
        computeMatrix()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        computeMatrix()
    }

    private fun computeMatrix() {
        val matrix = Matrix()
        if (scaleType == ScaleType.MATRIX && imgWidth != 0 && imgHeight != 0) {
            val scaleX = width.toFloat() / imgWidth
            matrix.postScale(scaleX, scaleX, 0.0f, 0.0f)
            imageMatrix = matrix

        }


    }
}