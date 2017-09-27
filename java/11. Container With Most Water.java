// O(n)
class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxVal = 0;
        while (i < j) {
            maxVal = Math.max(maxVal,Math.min(height[i], height[j]) * (j - i));
            int oldH;
            if (height[i] <= height[j]) {
                oldH = height[i];
                while (i < j && height[i] <= oldH) {
                    ++i;
                }
            } else {
                oldH = height[j];
                while (i < j && height[j] <= oldH) {
                    --j;
                }
            }
        }
        return maxVal;
    }
}
