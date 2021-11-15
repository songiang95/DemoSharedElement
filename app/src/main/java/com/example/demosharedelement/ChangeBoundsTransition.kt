package com.example.demosharedelement

import android.animation.Animator
import android.view.ViewGroup
import androidx.core.animation.addListener
import androidx.transition.ChangeBounds
import androidx.transition.TransitionValues


class ChangeBoundsTransition : ChangeBounds() {
    override fun createAnimator(
        sceneRoot: ViewGroup,
        startValues: TransitionValues?,
        endValues: TransitionValues?
    ): Animator? {
        val animator = super.createAnimator(sceneRoot, startValues, endValues)
        val startView = startValues?.view
        val endView = endValues?.view
        val endParentView = endView?.parent

        if (startView is TabImageView && endView is TabImageView && endParentView is TransitionConstraintLayout && animator != null) {
            endParentView.startTransition()
            endView.setImageDrawable(startView.drawable)

            animator.addListener({
                endView.setImageDrawable(null)
                endParentView.endTransition()
            })
        }

        return animator
    }

}