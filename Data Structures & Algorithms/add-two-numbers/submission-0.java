/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    private int get(ListNode currL1) {
        if(currL1 == null) {
            return 0;
        } else {
            return currL1.val;
        }
    }
    private ListNode move(ListNode currL1) {
        if(currL1 == null) {
            return currL1;
        } else {
            return currL1.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currL1 = l1;
        ListNode currL2 = l2;
        int carry = 0;
        ListNode result = null;
        ListNode head = null;
        while(currL1 != null || currL2 != null) {
            int num1 = get(currL1);
            currL1 = move(currL1);
            int num2 = get(currL2);
            currL2 = move(currL2);
            int sum = num1+num2+carry;
            carry = sum/10;
            if(head == null) {
                head = new ListNode(sum%10);
                result = head;
            } else {
                result.next = new ListNode(sum%10);
                result = result.next;
            }
            
        }
        if(carry != 0) {
            result.next = new ListNode(carry%10);
        }
        return head;
    }
}
