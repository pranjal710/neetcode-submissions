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
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode headNextNext = getStepsAhead(head);
        while(headNextNext != head) {
            if(head == null || headNextNext == null) {
                return false;
            } else {
                headNextNext = getStepsAhead(headNextNext);
                head = head.next;
            }
        }
        return headNextNext != null;
     }

     public ListNode getStepsAhead(ListNode head) {
        ListNode next = head.next;
        return next != null ? next.next : next;
     }
}
