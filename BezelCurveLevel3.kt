package com.hcbgame.demo

import android.animation.TypeEvaluator
import android.graphics.PointF

class BezelCurveLevel3
constructor(private val p1: PointF, private val p2: PointF) : TypeEvaluator<PointF> {


    /**
     * a 值参考 "杨辉三角"
     *
     * 三阶贝泽尔曲线
     * N = 4
     * a = 1,3,3,1
     * b = 3,2,1,0
     * c = 0,1,2,3
     * 公式: P0 * (1-t)^3 + 3P1 * (1-t)^2 * t + 3P2 * (1-t) * t^2 + P3 * t^3
     *
     */
    override fun evaluate(/*[0,1]*/t: Float, p0: PointF, p3: PointF): PointF = PointF().apply {
        x = (p0.x * Math.pow(1.0 - t, 3.0)
                + 3 * p1.x * Math.pow(1.0 - t, 2.0) * t
                + 3 * p2.x * (1.0 - t) * Math.pow(t.toDouble(), 2.0)
                + p3.x * Math.pow(t.toDouble(), 3.0)).toFloat()

        y = (p0.y * Math.pow(1.0 - t, 3.0)
                + 3 * p1.y * Math.pow(1.0 - t, 2.0) * t
                + 3 * p2.y * (1.0 - t) * Math.pow(t.toDouble(), 2.0)
                + p3.y * Math.pow(t.toDouble(), 3.0)).toFloat()
    }

}