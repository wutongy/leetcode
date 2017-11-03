// O(n)
class Solution {
    public int trap(int[] height) {
        int i = 0, j = height.length - 1;
        int leftMax = 0, rightMax = 0, max = 0;
        while (i <= j) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);
            if (leftMax < rightMax) {
                max += (leftMax - height[i]);
                ++i;
            } else {
                max += (rightMax - height[j]);
                --j;
            }
        }
        return max;
    }
}
