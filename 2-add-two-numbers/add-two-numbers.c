#include <stdlib.h> 

struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {

    struct ListNode* dummy_head = (struct ListNode*)malloc(sizeof(struct ListNode));
    dummy_head->val = 0;
    dummy_head->next = NULL;

    struct ListNode* current = dummy_head;

    struct ListNode* p1 = l1;
    struct ListNode* p2 = l2;

    int carry = 0;

    while (p1 != NULL || p2 != NULL || carry != 0) {

        int x = (p1 != NULL) ? p1->val : 0;
        int y = (p2 != NULL) ? p2->val : 0;

        int sum = x + y + carry;

        carry = sum / 10;
        int digit = sum % 10;

        struct ListNode* new_node = (struct ListNode*)malloc(sizeof(struct ListNode));
        new_node->val = digit;
        new_node->next = NULL;

        current->next = new_node;
        current = current->next;

        if (p1 != NULL) p1 = p1->next;
        if (p2 != NULL) p2 = p2->next;
    }

    struct ListNode* result = dummy_head->next;
    free(dummy_head);

    return result;
}
