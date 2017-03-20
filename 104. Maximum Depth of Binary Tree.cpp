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
    int maxDepth(TreeNode* root) {
        int res = 0;
        if (!root) return res;
        res++;
        queue<TreeNode*> q;
        q.push(root);
        int cur = 1, next = 0;
        while (!q.empty()) {
            TreeNode* root = q.front();
            q.pop();
            cur--;
            if (root->left) {
                q.push(root->left);
                next++;
            }
            if (root->right) {
                q.push(root->right);
                next++;
            }
            if (cur == 0 && next) {
                cur = next;
                next = 0;
                res++;
            }
        }
        return res;
    }
};

//Solution2
class Solution {
public:
    int maxDepth(TreeNode* root) {
        if (!root) return 0;
        return 1 + max(maxDepth(root->left), maxDepth(root->right));
    }
};