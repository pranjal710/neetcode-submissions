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
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        } else {
            ListNode[] next = recur(head);
            next[0].next = null;
            return next[1];
        }
    }

    public ListNode[] recur(ListNode head) {
        if(head == null) {
            return null;
        } else {
            ListNode[] next = recur(head.next);
            if(next == null) {
                return new ListNode[]{head, head};
            } else {
                next[0].next = head;
                next[0] = head;
                return next;
            }
        }
    }
}
