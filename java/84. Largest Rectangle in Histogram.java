// O(n) stack
class Solution {
    private class Rec {
        int val;
        int index;
        Rec(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        Stack<Rec> stack = new Stack<>();
        for (int i = 0; i < heights.length; ++i) {
            // System.out.println(i + " " + result);
            if (stack.isEmpty() || heights[i] >= stack.peek().val) {
                stack.push(new Rec(heights[i], i));
            } else {
                Rec top = null;
                while (!stack.isEmpty() && stack.peek().val > heights[i]) {
                    top = stack.peek();
                    result = Math.max(result, (i - top.index) * top.val);
                    stack.pop();
                }
                stack.push(new Rec(heights[i], top.index));
            }
        }
        while (!stack.isEmpty()) {
            // System.out.println(stack.peek().index + " " + stack.peek().val + " " + result);
            result = Math.max(result, (heights.length - stack.peek().index) * stack.peek().val);
            stack.pop();
        }
        return result;
    }
}
