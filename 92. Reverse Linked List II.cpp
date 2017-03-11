/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        ListNode **prev = &head;
        int steps = m;
        while (--steps) { pre = & (*prev)->next; }
        ListNode *cur = *pre;
        for (int i = m; i < n; i++) {
            ListNode *next_n = cur->next;
            cur->next = next_n->next;
            next_n->next = *pre;
            *prev = next_n;
        }
        return head;
    }
};