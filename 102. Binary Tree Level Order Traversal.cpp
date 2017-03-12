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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int> > res;
        if (!root) return res;
        res.push_back(vector<int>{});
        queue<TreeNode*> q;
        int cur = 1, nxt = 0;
        q.push(root);
        while (!q.empty()) {
            TreeNode* tp = q.front();
            q.pop();
            cur--;
            res.back().push_back(tp->val);
            if (tp->left) {
                q.push(tp->left);
                nxt++;
            }
            if (tp->right) {
                q.push(tp->right);
                nxt++;
            }
            if (cur == 0) {
                if (nxt == 0) break;
                cur = nxt;
                nxt = 0;
                res.push_back(vector<int>{});
            }
        }
        return res;
    }
};