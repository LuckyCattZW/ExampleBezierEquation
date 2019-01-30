package com.hcbgame.demo

import android.animation.TypeEvaluator
import android.graphics.PointF

class BezelCurveLevel5
constructor(private val p1: PointF, private val p2: PointF, private val p3: PointF, private val p4: PointF) :
    TypeEvaluator<PointF> {


    /**
     * a 值参考 "杨辉三角"
     *
     * 五阶贝泽尔曲线
     * N = 6
     * a = 1,5,10,10,5,1
     * b = 5,4,3,2,1,0
     * c = 0,1,2,3,4,5
     * 公式：P0 * (1-t)^5 + 5P1 * (1-t)^4 * t + 10P2 * (1-t)^3 * t^2 + 10P3 * (1-t)^2 * t^3 + 5P4 * (1-t) * t^4 + P5 * t^5
     *
     */
    override fun evaluate(/*[0,1]*/t: Float, p0: PointF, p5: PointF): PointF = PointF().apply {
        x = (p0.x * Math.pow(1.0 - t, 5.0)
                + 5 * p1.x * Math.pow(1.0 - t, 4.0) * t
                + 10 * p2.x * Math.pow(1.0 - t, 3.0) * Math.pow(t.toDouble(), 2.0)
                + 10 * p3.x * Math.pow(1.0 - t, 2.0) * Math.pow(t.toDouble(), 3.0)
                + 5 * p4.x * (1.0 - t) * Math.pow(t.toDouble(), 4.0)
                + p5.x * Math.pow(t.toDouble(), 5.0)).toFloat()

        y = (p0.y * Math.pow(1.0 - t, 5.0)
                + 5 * p1.y * Math.pow(1.0 - t, 4.0) * t
                + 10 * p2.y * Math.pow(1.0 - t, 3.0) * Math.pow(t.toDouble(), 2.0)
                + 10 * p3.y * Math.pow(1.0 - t, 2.0) * Math.pow(t.toDouble(), 3.0)
                + 5 * p4.y * (1.0 - t) * Math.pow(t.toDouble(), 4.0)
                + p5.y * Math.pow(t.toDouble(), 5.0)).toFloat()
    }

}