// O(n)
class Solution {
    public int climbStairs(int n) {
        int l1 = 1, l2 = 1;
        for (int i = 2; i <= n; ++i) {
            int temp = l2 + l1;
            l1 = l2;
            l2 = temp;
        }
        return l2;
    }
}
