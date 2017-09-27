// O(n)
class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int l1 = 1, l2 = 1;
        for (int i = 1; i < s.length(); ++i) {
            int temp = 0;
            if (s.charAt(i) != '0') {
                temp += l2;
            }
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                temp += l1;
            }
            l1 = l2;
            l2 = temp;
        }
        return l2;
    }
}
