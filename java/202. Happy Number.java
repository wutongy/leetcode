
class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        while (slow != 1) {
            slow = helper(slow);
            fast = helper(helper(fast));
            if (slow == fast) {
                break;
            }
        }
        return slow == 1;
    }

    private int helper(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n /= 10;
        }
        return res;
    }
}
