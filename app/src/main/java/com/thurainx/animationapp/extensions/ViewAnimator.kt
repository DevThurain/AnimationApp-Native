package com.thurainx.animationapp.extensions

import android.animation.Animator
import android.view.ViewPropertyAnimator
import android.view.animation.Animation.AnimationListener

fun ViewPropertyAnimator.setAnimationEndListener(onEnd: () -> Unit) {
    setListener(object : Animator.AnimatorListener{
        override fun onAnimationStart(p0: Animator) {

        }

        override fun onAnimationEnd(p0: Animator) {
            onEnd.invoke()
        }

        override fun onAnimationCancel(p0: Animator) {
        }

        override fun onAnimationRepeat(p0: Animator) {
        }

    })
}