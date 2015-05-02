/**
 * You are given two linked lists representing two non-negative numbers. 
 * 
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 
 * Output: 7 -> 0 -> 8
 */
 
#include <iostream>
using namespace std;

 struct ListNode {
     int val;
     ListNode *next;
     ListNode(int x) : val(x), next(NULL) {}
 };
 
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* current = new ListNode(0);
        ListNode* result = current;
        int plus = 0;
        while (l1 != NULL || l2 != NULL){
            if (l1 != NULL){
                plus += l1->val;
                l1 = l1->next;
            }
            if (l2 != NULL){
                plus += l2->val;
                l2 = l2->next;
            }
            current->next = new ListNode(plus % 10);
            plus = plus / 10;
            current = current->next;
        }
        if (plus == 1){
            current->next = new ListNode(1);
        }
        return result->next;
    }
};


void printResult(ListNode* list){
    while(list!=NULL){
        cout<<list->val<<endl;
        list = list->next;
    }
}

int main() {
    ListNode* l1 = new ListNode(5);
    ListNode* l2 = new ListNode(5);
    Solution* so = new Solution();
    printResult(so->addTwoNumbers(l1, l2));
    return 0;
}
