/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:

    int rob(TreeNode* root) {
        return helper(root).first;
    }

    pair<int, int> helper(TreeNode* root) {
        if (!root) return {0, 0};
        auto lnode = helper(root->left);
        auto rnode = helper(root->right);
        int childSum = lnode.first + rnode.first;
        int curSum = max(root->val + lnode.second + rnode.second, childSum);
        return {curSum, childSum};
    }
};