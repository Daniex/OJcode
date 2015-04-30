# You are given two linked lists representing two non-negative numbers.
# The digits are stored in reverse order and each of their nodes contain a single digit.
# Add the two numbers and return it as a linked list.
# 
# Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
# Output: 7 -> 0 -> 8

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param {ListNode} l1
    # @param {ListNode} l2
    # @return {ListNode}
    def addTwoNumbers(self, l1, l2):
        ref = ListNode(0)
        result = ref
        plus = 0
        while l1 != None and l2 !=None:
            sum = l1.val + l2.val + plus
            ref.next = ListNode(sum % 10)
            plus = sum / 10
            l1 = l1.next
            l2 = l2.next
            ref = ref.next;
        if l1 != None:
            ref.next = l1
        if l2 != None:
            ref.next = l2
        while plus != 0:
            if ref.next == None:
                ref.next = ListNode(0)
            sum = ref.next.val + plus
            plus = sum / 10
            ref.next.val = sum % 10
            ref = ref.next
        return result.next


    def addTwoNumbers2(self, l1, l2):
        dummy = ListNode(0)
        current, carry = dummy, 0

        while l1 is not None or l2 is not None:
            val = carry
            if l1 is not None:
                val += l1.val
                l1 = l1.next
            if l2 is not None:
                val += l2.val
                l2 = l2.next
            carry, val = val / 10, val % 10
            current.next = ListNode(val)
            current = current.next

        if carry == 1:
            current.next = ListNode(1)

        return dummy.next
        
def printresult(l):
    while l != None:
        print l.val
        l = l.next


if __name__ == '__main__':
    a, a.next, a.next.next = ListNode(2), ListNode(4), ListNode(3)
    b, b.next, b.next.next = ListNode(5), ListNode(6), ListNode(4)
    result = Solution().addTwoNumbers(a, b)
    print "{0} -> {1} -> {2}".format(result.val, result.next.val, result.next.next.val)
    printresult(Solution().addTwoNumbers(ListNode(5), ListNode(5)))
