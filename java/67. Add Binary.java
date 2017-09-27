// O(len(a) + len(b))
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int numA = 0;
            int numB = 0;
            if (i >= 0) {
                numA = a.charAt(i--) - '0';
            }
            if (j >= 0) {
                numB = b.charAt(j--) - '0';
            }
            int sum = numA + numB + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
