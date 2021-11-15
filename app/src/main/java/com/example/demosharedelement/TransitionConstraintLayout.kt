package com.example.demosharedelement

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Constraints
import androidx.core.view.ViewCompat
import androidx.core.view.allViews
import androidx.core.view.children

class TransitionConstraintLayout(context: Context, attrs: AttributeSet?) :
    ConstraintLayout(context, attrs) {
    private val sharedImageView = TabImageView(context, null)

    init {
        sharedImageView.layoutParams = Constraints.LayoutParams(
            Constraints.LayoutParams.MATCH_PARENT,
            Constraints.LayoutParams.MATCH_PARENT
        )
        sharedImageView.scaleType = ImageView.ScaleType.MATRIX
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        addView(sharedImageView)
        ViewCompat.setTransitionName(sharedImageView, "sharedImageView")
    }

    fun getSharedImageView(): TabImageView {
        return sharedImageView
    }

    fun startTransition() {
        children.forEach {
            it.visibility = if (it != sharedImageView) INVISIBLE else VISIBLE
        }
    }

    fun endTransition() {
        sharedImageView.setImageDrawable(null)
        children.forEach {
            it.visibility = VISIBLE
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        removeView(sharedImageView)
    }

}