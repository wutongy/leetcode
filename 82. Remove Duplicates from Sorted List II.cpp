//Solution1
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
    ListNode* deleteDuplicates(ListNode* head) {
        if (!head || !head->next) return head;
        ListNode* newHead = NULL;
        if (head->val != head->next->val) {
            newHead = head;
            head->next = deleteDuplicates(head->next);
        } else {
            int val = head->val;
            head = head->next->next;
            while (head && head->val == val) {
                head = head->next;
            }
            if (head) {
                newHead = deleteDuplicates(head);
            }
        }
        return newHead;
    }
};

//Solution2
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if (!head || !head->next) return head;
        ListNode *p = new ListNode(0);
        ListNode *newHead = p;
        int tmp;
        while (head && head->next) {
            if (head->val != head->next->val) {
                p->next = head;
                p = p->next;
                head = head->next;
            } else {
                tmp = head->val;
                while (head && tmp == head->val) {
                    head = head->next;
                }
            }
        }
        p->next = head;
        return newHead->next;
    }
}