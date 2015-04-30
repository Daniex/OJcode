
/**
 * You are given two linked lists representing two non-negative numbers. 
 * 
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 
 * Output: 7 -> 0 -> 8
 */

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode head = new ListNode(0);
		ListNode cur = head;
		int plus = 0;
		while (l1 != null && l2 != null) {
			int sum = l1.val + l2.val + plus;
			plus = sum / 10;
			sum = sum % 10;
			cur.next = new ListNode(sum);
			cur = cur.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		if (l1 != null) {
			if (plus != 0) {
				cur.next = addTwoNumbers(l1, new ListNode(plus));
			} else {
				cur.next = l1;
			}
		} else if (l2 != null) {
			if (plus != 0) {
				cur.next = addTwoNumbers(l2, new ListNode(plus));
			} else {
				cur.next = l2;
			}
		} else if (plus != 0) {
			cur.next = new ListNode(plus);
		}

		return head.next;
	}
}

public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode current = dummy;
    int carry = 0;
    while (l1 != null || l2 != null) {
      int v1 = (l1 == null) ? 0 : l1.val, v2 = (l2 == null) ? 0 : l2.val;
      int sum = v1 + v2 + carry;

      carry = sum / 10;
      current.next = new ListNode(sum % 10);

      l1 = (l1 == null) ? null : l1.next;
      l2 = (l2 == null) ? null : l2.next;
      current = current.next;
    }
    if (carry > 0) {
      current.next = new ListNode(carry);
    }
    return dummy.next;
  }
}
