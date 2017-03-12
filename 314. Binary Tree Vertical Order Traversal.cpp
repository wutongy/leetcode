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
     vector<vector<int>> verticalOrder(TreeNode* root) {
        map<int, vector<int>> cols;
        queue<pair<TreeNode*, int>> q;
        if (root)
            q.emplace(root, 0);
        while (q.size()) {
            auto node = q.front().first;
            int x = q.front().second;
            q.pop();
            cols[x].push_back(node->val);
            if (node->left)
                q.emplace(node->left, x-1);
            if (node->right)
                q.emplace(node->right, x+1);
        }
        vector<vector<int>> result;
        for (auto col : cols)
            result.push_back(col.second);
        return result;
    }
};

//Solution2
struct doubleList {
    vector<int> val;
    doubleList *left;
    doubleList *right;
};
class Solution {
public:
    vector<vector<int>> verticalOrder(TreeNode* root) {
        vector<vector<int>> res;
        if (!root) { return res; }
        doubleList *mid = new doubleList();
        queue<pair<TreeNode*, doubleList*> > Q;
        Q.push({root, mid});
        doubleList *leftbound = mid;
        while (!Q.empty()) {
            auto node = Q.front();
            Q.pop();
            node.second->val.push_back(node.first->val);
            if (node.first->left) {
                if (node.second->left == NULL) {
                    node.second->left = new doubleList();
                    node.second->left->right = node.second;
                    leftbound = node.second->left;
                }
                Q.push({node.first->left, node.second->left});
            }
            if (node.first->right) {
                if (node.second->right == NULL) {
                    node.second->right = new doubleList();
                    node.second->right->left = node.second;
                }
                Q.push({node.first->right, node.second->right});
            }
        }
        while (leftbound) {
            res.push_back(leftbound->val);
            leftbound = leftbound->right;
        }
        return res;
    }
};