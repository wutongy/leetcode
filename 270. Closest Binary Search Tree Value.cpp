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
    int closestValue(TreeNode* root, double target) {
        int result = 0;
        double prevdiff = numeric_limits<double>::max();
        while (root) {
            double sub = abs(root->val - target);
            if (sub < prevdiff) {
                result = root->val;
                prevdiff = sub;
            }
            if (target > root->val) root = root->right;
            else root = root->left;
        }
        return result;
    }
};