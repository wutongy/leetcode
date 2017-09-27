// O(n)
class Solution {
    private class Complex {
        int real;
        int complex;
        public Complex(String s) {
            real = 0;
            complex = 0;
            int i = 0;
            int negr = 1;
            if (s.charAt(0) == '-') {
                negr = -1;
                ++i;
            }
            while (s.charAt(i) != '+') {
                real = real * 10 + (s.charAt(i)- '0');
                ++i;
            }
            real *= negr;
            ++i;
            int negc = 1;
            if (s.charAt(i) == '-') {
                negc = -1;
                ++i;
            }
            while (s.charAt(i) != 'i' ) {
                complex = complex * 10 + (s.charAt(i) - '0');
                ++i;
            }
            complex *= negc;
        }

        public String toString() {
            return real + "+" + (complex < 0 ? "-" + (-1 * complex) : complex) + "i";
        }

        public void multiply(Complex c) {
            int tempReal = this.real;
            this.real = this.real * c.real - this.complex * c.complex;
            this.complex = tempReal * c.complex + c.real * this.complex;
        }
    }

    public String complexNumberMultiply(String a, String b) {
        Complex ac = new Complex(a);
        Complex bc = new Complex(b);
        ac.multiply(bc);
        return ac.toString();
    }

}
