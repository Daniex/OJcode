/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
**/
/**
 * Definition for singly-linked list.
 * 
 */
function ListNode(val) {
    this.val = val;
    this.next = null;
}
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    var plus = 0;
    var result = new ListNode();
    var ref = result;
    while (l1 !== null || l2 !== null){
        if (l1){
            plus += l1.val;
            l1 = l1.next;
        }
        if (l2){
            plus += l2.val;
            l2 = l2.next;
        }
        ref.next = new ListNode(plus % 10);
        plus = parseInt(plus / 10);
        ref = ref.next;
    }
    if (plus == 1){
        ref.next = new ListNode(1);
    }
    return result.next;
};

function printResult(data){
    while(data){
        document.writeln(data.val);
		data = data.next;
    }
}
var l1 = new ListNode(5);
//l1.next = new ListNode(8);
var l2 = new ListNode(5);
data = addTwoNumbers(l1, l2);
printResult(data);
