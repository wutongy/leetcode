// O(n)
public class Solution {
    public boolean isStrobogrammatic(String num) {
        int left = 0, right = num.length() - 1;
        while (left <= right) {
            if (left == right) {
                return num.charAt(left) == '1' || num.charAt(left) == '8' || num.charAt(left) == '0';
            }
            Character l = num.charAt(left);
            if (helper(l) == false) {
                return false;
            }
            Character r = num.charAt(right);
            if (helper(r) == false) {
                return false;
            }
            if ((l == '1' && r == '1') || (l == '8' && r == '8') || (l == '6' && r == '9') || (l == '9' && r == '6') || (l == '0' && r == '0')) {
                left += 1;
                right -= 1;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean helper(Character c) {
        if (c == '6' || c == '9' || c =='1' || c =='8' || c == '0') {
            return true;
        }
        return false;
    }
}
