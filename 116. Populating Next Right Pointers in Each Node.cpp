/**
 * Definition for binary tree with next pointer.
 * struct TreeLinkNode {
 *  int val;
 *  TreeLinkNode *left, *right, *next;
 *  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 * };
 */
class Solution {
public:
    void connect(TreeLinkNode *root) {
        if (!root) return;
        queue<TreeLinkNode*> q;
        q.push(root);
        int cur = 1, next = 0;
        while (!q.empty()) {
            TreeLinkNode* top = q.front();
            q.pop();
            cur--;
            if (cur > 0) {
                top->next = q.front();
            }

            if (top->left) q.push(top->left), next++;
            if (top->right) q.push(top->right), next++;

            if (cur == 0) {
                cur = next;
                next = 0;
            }
        }
    }
};