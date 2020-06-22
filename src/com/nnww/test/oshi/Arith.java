package com.nnww.test.oshi;

import java.math.BigDecimal;

public class Arith {

    public static double mul(double d, double d2) {
        return d * d2;
    }

    public static double div(double d, double d2, int i) {
        return round(d / d2, i);
    }

    public static Double round(Double num, int i) {
        BigDecimal b = new BigDecimal(num);
        return b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
