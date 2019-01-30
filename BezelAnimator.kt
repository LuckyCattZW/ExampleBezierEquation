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
        this, null, when (controlPointF.size) {
            1 -> BezelCurveLevel2(controlPointF[0])
            2 -> BezelCurveLevel3(controlPointF[0], controlPointF[1])
            3 -> BezelCurveLevel4(controlPointF[0], controlPointF[1], controlPointF[2])
            4 -> BezelCurveLevel5(controlPointF[0], controlPointF[1], controlPointF[2], controlPointF[3])
            else -> throw IllegalArgumentException("throw IllegalArgumentException("Params \"controlPointF\" size must be > 0 && < 4")")
        }, startPoint, endPoint
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
