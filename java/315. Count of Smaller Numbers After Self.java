// O(n^2)
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        res.add(0);
        for (int i = nums.length - 2; i >= 0; --i) {
            int count = insertNode(root, nums[i]);
            res.add(count);
        }
        Collections.reverse(res);
        return res;
    }

    private int insertNode(TreeNode root, int val) {
        int count = 0;
        while (true) {
            if (val <= root.val) {
                ++root.count;
                if (root.left == null) {
                    root.left = new TreeNode(val);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                count += root.count;
                if (root.right == null) {
                    root.right = new TreeNode(val);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return count;
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        int count = 1;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
