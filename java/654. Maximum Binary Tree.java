/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// O(nlogn)
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (end < start) {
            return null;
        }
        if (end == start) {
            return new TreeNode(nums[start]);
        }
        int maxNum = nums[start], index = start;
        int i = start + 1;
        while (i <= end) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                index = i;
            }
            ++i;
        }
        TreeNode cur = new TreeNode(maxNum);
        cur.left = helper(nums, start, index - 1);
        cur.right= helper(nums, index + 1, end);
        return cur;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// O(n)
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        LinkedList<TreeNode> list = new LinkedList<>();
        for(int num : nums) {
            TreeNode cur = new TreeNode(num);
            while (!list.isEmpty() && list.peekFirst().val < cur.val) {
                cur.left = list.pop();
            }
            if (!list.isEmpty()) {
                list.peekFirst().right = cur;
            }
            list.push(cur);
        }
        return list.peekLast();
    }
}
