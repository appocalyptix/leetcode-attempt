package com.math;

/**
 * 50. Pow(x, n)
 * <p>
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 */
public class PowerX {
    public double myPow(double x, int n) {

        boolean isNeg = false;
        if (n < 0) {
            isNeg = true;
            n = 0 - n;
        }
        double d = pow(x, n);
        if (isNeg) {
            return 1 / d;
        }
        return d;
    }

    private double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        double d = pow(x, n / 2);
        if (n % 2 == 0) {
            return d * d;
        } else {
            return d * d * x;
        }
    }

    public static void main(String[] args) {
        PowerX px = new PowerX();
        System.out.println(px.myPow(2, 8));
    }
}
