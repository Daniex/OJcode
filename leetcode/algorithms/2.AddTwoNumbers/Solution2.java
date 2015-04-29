/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
**/

public class Solution2{

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
 
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l2; 
        }
        int plus = 0;
        ListNode next = new ListNode(0);
        ListNode result = next;
        while (l1 != null && l2 != null){
            next.next = new ListNode(0);
            next = next.next;
            int sum = l1.val + l2.val + plus;
            plus = sum / 10;
            next.val = sum % 10;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null){
            next.next = l1;
        }
        if (l2 != null){
            next.next = l2;
        }
        while (plus != 0){
            if (next.next == null){
                next.next = new ListNode(0);
            }
            next = next.next;
            int sum = next.val + plus;
            plus = sum / 10;
            next.val = sum % 10;
        }
        return result.next;
    }
    
    
    public void test(){
        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(3);
         
        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(4);
        
        ListNode result = addTwoNumbers(list1, list2);
        while (result!= null){
            System.out.println(result.val);
            result = result.next;
        }
    }
    
    public void test2(){
        ListNode list1 = new ListNode(5);
        ListNode list2 = new ListNode(5);
        
        ListNode result = addTwoNumbers(list1, list2);
        while (result!= null){
            System.out.println(result.val);
            result = result.next;
        }
    }
    
    public static void main(String args[]) { 
        new Solution2().test();
        new Solution2().test2();
    }
    
}