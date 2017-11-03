// O(n)
class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = Math.min(height[i], height[j]) * (j - i);
        while (i < j - 1) {
            if (height[i] <= height[j]) {
                ++i;
                while (i < j - 1 && height[i] <= height[i - 1]) {
                    ++i;
                }
            } else {
                --j;
                while (i < j - 1 && height[j] <= height[j + 1]) {
                    --j;
                }
            }
            res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
        }
        return res;
    }
}
