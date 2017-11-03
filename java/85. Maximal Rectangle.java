// O(n^2)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int[] height = new int[matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0;
            }
            res = Math.max(res, maxArea(height));
        }
        return res;
    }

    private int maxArea(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i <= nums.length; ++i) {
            int cur = i == nums.length ? 0 : nums[i];
            while (!stack.isEmpty() && nums[stack.peek()] >= cur) {
                int h = nums[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                res = Math.max(res, h * (i - 1 - left));
            }
            stack.push(i);
        }
        return res;
    }
}
