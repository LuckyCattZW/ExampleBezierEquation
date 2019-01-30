package com.hcbgame.demo

import android.animation.TypeEvaluator
import android.graphics.PointF

class BezelCurveLevel4
constructor(private val p1: PointF, private val p2: PointF, private val p3: PointF) : TypeEvaluator<PointF> {


    /**
     * a 值参考 "杨辉三角"
     *
     * 四阶贝泽尔曲线
     * N = 5
     * a = 1,4,6,4,1
     * b = 4,3,2,1,0
     * c = 0,1,2,3,4
     * 公式： P0 * (1-t)^4 + 4P1 * (1-t)^3 * t + 6P2 * (1-t)^2 * t^2 + 4P3 * (1-t) * t^3 + P4 * t^4
     *
     */
    override fun evaluate(/*[0,1]*/t: Float, p0: PointF, p4: PointF): PointF = PointF().apply {
        x = (p0.x * Math.pow(1.0 - t, 4.0)
                + 4 * p1.x * Math.pow(1.0 - t, 3.0) * t
                + 6 * p2.x * Math.pow(1.0 - t, 2.0) * Math.pow(t.toDouble(), 2.0)
                + 4 * p3.x * (1.0 - t) * Math.pow(t.toDouble(), 3.0)
                + p4.x * Math.pow(t.toDouble(), 4.0)).toFloat()

        y = (p0.y * Math.pow(1.0 - t, 4.0)
                + 4 * p1.y * Math.pow(1.0 - t, 3.0) * t
                + 6 * p2.y * Math.pow(1.0 - t, 2.0) * Math.pow(t.toDouble(), 2.0)
                + 4 * p3.y * (1.0 - t) * Math.pow(t.toDouble(), 3.0)
                + p4.y * Math.pow(t.toDouble(), 4.0)).toFloat()
    }

}