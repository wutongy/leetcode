//
class Solution {
    private class Fraction {
        int num;
        int den;
        Fraction() {
            this.num = 0;
            this.den = 1;
        }
        Fraction(int num, int den) {
            this.num = num;
            this.den = den;
        }
        void add(Fraction f) {
            if (num == 0) {
                this.num = f.num;
                this.den = f.den;
                return;
            }
            this.num = this.num * f.den + this.den * f.num;
            this.den = f.den * this.den;
            if (this.num == 0) {
                this.den = 1;
            } else {
                int gcd = gcd(Math.abs(this.num), this.den);
                this.num /= gcd;
                this.den /= gcd;
            }
        }
        String getString() {
            return  this.num + "/" + this.den;
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public String fractionAddition(String expression) {
        int sign = 1;
        int i = 0;
        if (expression.charAt(0) == '-') {
            ++i;
            sign = -1;
        }
        Fraction f = new Fraction();
        while (i < expression.length()) {
            int j = i;
            int num = 0, den = 1, accum = 0;
            while (j < expression.length() && expression.charAt(j) != '+' && expression.charAt(j) != '-') {
                if (expression.charAt(j) == '/') {
                    num = sign * accum;
                    accum = 0;
                } else {
                    accum = accum * 10 + (expression.charAt(j) - '0');
                }
                ++j;
            }
            den = accum;
            f.add(new Fraction(num, den));
            if (j < expression.length()) {
                sign = expression.charAt(j) == '+' ? 1 : -1;
            }
            i = j + 1;
        }
        return f.getString();
    }
}
