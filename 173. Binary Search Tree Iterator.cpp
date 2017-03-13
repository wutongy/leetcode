/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class BSTIterator {
private:
    stack<TreeNode*> stk;
public:
    BSTIterator(TreeNode *root) {
        while (root) {
            stk.push(root);
            root = root->left;
        }
    }

    /** @return whether we have a next smallest number */
    bool hasNext() {
        return  (!stk.empty());
    }

    /** @return the next smallest number */
    int next() {
       int res = stk.top()->val;
       auto tmp = stk.top();
       stk.pop();
       if (tmp->right) {
           tmp = tmp->right;
           stk.push(tmp);
           while (tmp->left) {
               tmp = tmp->left;
               stk.push(tmp);
           }
       }
       return res;
    }
};

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = BSTIterator(root);
 * while (i.hasNext()) cout << i.next();
 */