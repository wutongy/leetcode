//Solution1:
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
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        vector<TreeNode*> path1, path2;
        path1.push_back(root), path2.push_back(root);
        search(p, root, path1);
        search(q, root, path2);
        while (path1.size() > path2.size()) {
            path1.pop_back();
        }
        while (path2.size() > path1.size()) {
            path2.pop_back();
        }
        while (path1.back() != path2.back()) {
            path1.pop_back();
            path2.pop_back();
        }
        return path1.back();
    }

    bool search(TreeNode* &target, TreeNode* head, vector<TreeNode*> &path) {
        if (target == head)
            return true;
        if (!head->left && !head->right)
            return false;
        if (head->left) {
            path.push_back(head->left);
            if (search(target, head->left, path))
                return true;
            path.pop_back();
        }
        if (head->right) {
            path.push_back(head->right);
            if (search(target, head->right, path))
                return true;
            path.pop_back();
        }
        return false;
    }
};

//Solution2
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode *root, TreeNode *p, TreeNode *q) {
        if (root == p || root == q || root == NULL) return root;
        TreeNode *left = lowestCommonAncestor(root->left, p, q), *right = lowestCommonAncestor(root->right, p, q);
        return left && right ? root : left ? left : right;
    }
}