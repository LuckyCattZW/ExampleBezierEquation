package com.hcbgame.demo

import android.animation.TypeEvaluator
import android.graphics.PointF

class BezelCurveLevel2
constructor(private val p1: PointF) : TypeEvaluator<PointF> {


    /**
     * a 值参考 "杨辉三角"
     *
     * 二阶贝泽尔曲线
     * N = 3
     * a = 1,2,1
     * b = 2,1,0
     * c = 0,1,2
     * 公式：P0 * (1-t)^2 + 2P1 * (1-t) * t + P2 * t^2
     *
     */
    override fun evaluate(/*[0,1]*/t: Float, p0: PointF, p2: PointF): PointF = PointF().apply {
        x = (p0.x * Math.pow(1.0 - t, 2.0)
                + 2 * p1.x * (1.0 - t) * t
                + p2.x * Math.pow(t.toDouble(), 2.0)).toFloat()

        y = (p0.y * Math.pow(1.0 - t, 2.0)
                + 2 * p1.y * (1.0 - t) * t
                + p2.y * Math.pow(t.toDouble(), 2.0)).toFloat()
    }

}
