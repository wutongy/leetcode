// O(n)
public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int p1 = num1.length() - 1, p2 = num2.length() - 1;
        int carry = 0;
        while (p1 >= 0 || p2 >= 0) {
            int n1 = (p1 >= 0) ? (num1.charAt(p1) - '0') : 0;
            int n2 = (p2 >= 0) ? (num2.charAt(p2) - '0') : 0;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            p1--;
            p2--;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
