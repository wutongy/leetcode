// O(len(n1) * len(n2))
class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] prod = new int[m + n];
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                int idx =  i + j + 1;
                prod[idx] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                prod[idx - 1] += prod[idx] / 10;
                prod[idx] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int p : prod) {
            if (!(p == 0 && sb.length() == 0)) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
