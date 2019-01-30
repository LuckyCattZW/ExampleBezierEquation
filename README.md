# ExampleBezierEquation
贝泽尔曲线公式

[@简书：n阶贝塞尔曲线计算公式](https://www.jianshu.com/p/7c56103dcf63)

```java
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
```

<img src="https://gss2.bdstatic.com/9fo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=b15f585fc3ea15ce55e3e85bd7695196/7e3e6709c93d70cf89a39cd7f2dcd100bba12b8a.jpg"/>

```java
    /**
     * 打印杨辉三角
     */
    @Test
    public void test1() {
        final int NMAX = 10;//行数
        // allocate triangular array
        int[][] odds = new int[NMAX + 1][];
        for (int n = 0; n <= NMAX; n++)
            odds[n] = new int[n + 1];
        // fill triangular array
        for (int n = 0; n < odds.length; n++)
            for (int k = 0; k < odds[n].length; k++) {
                /*
                 * compute binomial coefficient n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
                 */
                int lotteryOdds = 1;
                for (int i = 1; i <= k; i++)
                    lotteryOdds = lotteryOdds * (n - i + 1) / i;

                odds[n][k] = lotteryOdds;
            }

        // print triangular array
        for (int[] row : odds) {
            for (int odd : row){
                System.out.printf("%4d", odd);
            }
            System.out.println();
        }
    }
```
