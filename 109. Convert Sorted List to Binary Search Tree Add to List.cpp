/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
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
    TreeNode* sortedListToBST(ListNode* head) {
        int size = 0;
        ListNode* save = head;
        while (head) {
            head = head->next;
            size++;
        }
        head = save;
        TreeNode* root = helper(save, size);
        return root;
    }
    TreeNode* helper(ListNode* &head, int size) {
        if (!head || size <= 0) return NULL;
        int rightSize = (size - 1) / 2;
        TreeNode* left = helper(head, size - 1 - rightSize);
        TreeNode* root = new TreeNode(head->val);
        head = head->next;
        root->left = left;
        root->right = helper(head, rightSize);
        return root;
    }
};