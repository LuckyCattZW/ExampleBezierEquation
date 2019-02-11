package com.hcbgame.demo

import android.animation.TypeEvaluator
import android.graphics.PointF

class BezelCurveLevel
constructor(private vararg val pc: PointF) : TypeEvaluator<PointF> {


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
     * 三阶贝泽尔曲线
     * N = 4
     * a = 1,3,3,1
     * b = 3,2,1,0
     * c = 0,1,2,3
     * 公式: P0 * (1-t)^3 + 3P1 * (1-t)^2 * t + 3P2 * (1-t) * t^2 + P3 * t^3
     *
     * 四阶贝泽尔曲线
     * N = 5
     * a = 1,4,6,4,1
     * b = 4,3,2,1,0
     * c = 0,1,2,3,4
     * 公式： P0 * (1-t)^4 + 4P1 * (1-t)^3 * t + 6P2 * (1-t)^2 * t^2 + 4P3 * (1-t) * t^3 + P4 * t^4
     *
     * 五阶贝泽尔曲线
     * N = 6
     * a = 1,5,10,10,5,1
     * b = 5,4,3,2,1,0
     * c = 0,1,2,3,4,5
     * 公式：P0 * (1-t)^5 + 5P1 * (1-t)^4 * t + 10P2 * (1-t)^3 * t^2 + 10P3 * (1-t)^2 * t^3 + 5P4 * (1-t) * t^4 + P5 * t^5
     *
     */
    override fun evaluate(/*[0,1]*/t: Float, ps: PointF, pe: PointF): PointF =
        when (pc.size) {
            1 -> PointF().apply {
                x = (ps.x * Math.pow(1.0 - t, 2.0)
                        + 2 * pc[0].x * (1.0 - t) * t
                        + pe.x * Math.pow(t.toDouble(), 2.0)).toFloat()

                y = (ps.y * Math.pow(1.0 - t, 2.0)
                        + 2 * pc[0].y * (1.0 - t) * t
                        + pe.y * Math.pow(t.toDouble(), 2.0)).toFloat()
            }
            2 -> PointF().apply {
                x = (ps.x * Math.pow(1.0 - t, 3.0)
                        + 3 * pc[0].x * Math.pow(1.0 - t, 2.0) * t
                        + 3 * pc[1].x * (1.0 - t) * Math.pow(t.toDouble(), 2.0)
                        + pe.x * Math.pow(t.toDouble(), 3.0)).toFloat()

                y = (ps.y * Math.pow(1.0 - t, 3.0)
                        + 3 * pc[0].y * Math.pow(1.0 - t, 2.0) * t
                        + 3 * pc[1].y * (1.0 - t) * Math.pow(t.toDouble(), 2.0)
                        + pe.y * Math.pow(t.toDouble(), 3.0)).toFloat()
            }
            3 -> PointF().apply {
                x = (ps.x * Math.pow(1.0 - t, 4.0)
                        + 4 * pc[0].x * Math.pow(1.0 - t, 3.0) * t
                        + 6 * pc[1].x * Math.pow(1.0 - t, 2.0) * Math.pow(t.toDouble(), 2.0)
                        + 4 * pc[2].x * (1.0 - t) * Math.pow(t.toDouble(), 3.0)
                        + pe.x * Math.pow(t.toDouble(), 4.0)).toFloat()

                y = (ps.y * Math.pow(1.0 - t, 4.0)
                        + 4 * pc[0].y * Math.pow(1.0 - t, 3.0) * t
                        + 6 * pc[1].y * Math.pow(1.0 - t, 2.0) * Math.pow(t.toDouble(), 2.0)
                        + 4 * pc[2].y * (1.0 - t) * Math.pow(t.toDouble(), 3.0)
                        + pe.y * Math.pow(t.toDouble(), 4.0)).toFloat()
            }
            4 -> PointF().apply {
                x = (ps.x * Math.pow(1.0 - t, 5.0)
                        + 5 * pc[0].x * Math.pow(1.0 - t, 4.0) * t
                        + 10 * pc[1].x * Math.pow(1.0 - t, 3.0) * Math.pow(t.toDouble(), 2.0)
                        + 10 * pc[2].x * Math.pow(1.0 - t, 2.0) * Math.pow(t.toDouble(), 3.0)
                        + 5 * pc[3].x * (1.0 - t) * Math.pow(t.toDouble(), 4.0)
                        + pe.x * Math.pow(t.toDouble(), 5.0)).toFloat()

                y = (ps.y * Math.pow(1.0 - t, 5.0)
                        + 5 * pc[0].y * Math.pow(1.0 - t, 4.0) * t
                        + 10 * pc[1].y * Math.pow(1.0 - t, 3.0) * Math.pow(t.toDouble(), 2.0)
                        + 10 * pc[2].y * Math.pow(1.0 - t, 2.0) * Math.pow(t.toDouble(), 3.0)
                        + 5 * pc[3].y * (1.0 - t) * Math.pow(t.toDouble(), 4.0)
                        + pe.y * Math.pow(t.toDouble(), 5.0)).toFloat()
            }
            else -> ps
        }

}