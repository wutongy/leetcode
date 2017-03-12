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
    bool isValidBST(TreeNode* root) {
        TreeNode *curr = root, *prev = NULL, *pred = NULL;
        bool valid = true;
        while (curr != NULL) {
            if (curr->left == NULL) {
                if (prev != NULL) {
                    if ((curr->val) <= (prev->val)) {
                        valid = false;
                    }
                }
                prev = curr;
                curr = curr->right;
            } else {
                pred = curr->left;
                while (pred->right != NULL && pred->right != curr) {
                    pred = pred->right;
                }
                if (pred->right == curr) {
                    pred->right = NULL;
                    if (prev != NULL) {
                        if (curr->val <= prev->val) {
                            valid = false;
                        }
                    }
                    prev = curr;
                    curr = curr->right;
                } else {
                    pred->right = curr;
                    curr = curr->left;
                }
            }
        }
        return valid;
    }
};