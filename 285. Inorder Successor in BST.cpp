//Solution1
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
    TreeNode* inorderSuccessor(TreeNode* root, TreeNode* p) {
        TreeNode* prev = NULL, *cur = root, *pred, *res = NULL;
        while (cur) {
            if (!cur->left) {
                if (prev == p) {
                    res = cur;
                }
                prev = cur;
                cur = cur->right;
            } else {
                pred = cur->left;
                while (pred->right != NULL && pred->right != cur) {
                    pred = pred->right;
                }
                if (pred->right == NULL) {
                    pred->right = cur;
                    cur = cur->left;
                } else if (pred->right == cur) {
                    pred->right = NULL;
                    if (pred == p) {
                        res = cur;
                    }
                    prev = cur;
                    cur = cur->right;
                }
            }
        }
        return res;
    }
};

//Solution2
TreeNode* inorderSuccessor(TreeNode* root, TreeNode* p) {
    TreeNode *successor = NULL;
    while (root) {
        if (p->val < root->val) {
            successor = root;
            root = root->left;
        } else {
            root = root->right;
        }
    }
    return successor;
}

//Predecessor
TreeNode* inorderPredecessor(TreeNode* root, TreeNode* p) {
    TreeNode *predecessor = NULL;
    while (root) {
        if (p->val > root->val) {
            predecessor = root;
            root = root->right;
        } else {
            root = root->left;
        }
    }
    return predecessor;
}