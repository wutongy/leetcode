
 //Definition for binary tree with next pointer.
struct TreeLinkNode {
   int val;
   TreeLinkNode *left, *right, *next;
   TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 };

class Solution {
public:
    void connect(TreeLinkNode *root) {
        if (!root) return;
        queue<TreeLinkNode*> q;
        q.push(root);
        int currCnt = 1, nxtCnt = 0;
        while (!q.empty()) {
            TreeLinkNode* peek = q.front();
            q.pop();
            if (--currCnt > 0) {
                peek->next = q.front();
            } else {
                peek->next = NULL;
            }
            if (peek->left) {
                q.push(peek->left);
                nxtCnt++;
            }
            if (peek->right) {
                q.push(peek->right);
                nxtCnt++;
            }
            if (currCnt == 0) {
                currCnt = nxtCnt;
                nxtCnt = 0;
            }
        }
    }
};