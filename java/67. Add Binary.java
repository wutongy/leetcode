// O(n)
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int aNum = i >= 0 ? a.charAt(i) - '0' : 0;
            int bNum = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = aNum + bNum + carry;
            sb.append(sum % 2);
            carry = sum/2;
            --i;
            --j;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
