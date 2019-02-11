package com.hcbgame.demo

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.graphics.PointF
import android.view.View

fun View.generatedBezierObjectAnimator(
    startPoint: PointF, endPoint: PointF, vararg controlPointF: PointF
): ObjectAnimator =
    ObjectAnimator.ofObject(
        this, null, BezelCurveLevel(*controlPointF), startPoint, endPoint
    ).apply {
        addUpdateListener {
            val pointF = it.animatedValue as PointF
            ((it as? ObjectAnimator)?.target as? View)?.apply target@{
                this@target.x = pointF.x
                this@target.y = pointF.y
            }
        }
        addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                (animation as? ObjectAnimator)?.removeAllUpdateListeners()
            }
        })
    }