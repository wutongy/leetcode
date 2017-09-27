// O(nlogn)
class Solution {
    public String findContestMatch(int n) {
        String[] strs = new String[n];
        for (int i = 1; i <= n; ++i) {
            strs[i - 1] = String.valueOf(i);
        }
        int count = n;
        while (count > 1) {
            int i = 0, j = count - 1;
            while (i < j) {
                strs[i] = "(" + strs[i] + "," + strs[j] + ")";
                ++i;
                --j;
            }
            count /= 2;
        }
        return strs[0];
    }
}
