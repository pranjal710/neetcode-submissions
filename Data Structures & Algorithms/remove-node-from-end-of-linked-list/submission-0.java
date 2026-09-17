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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = getLength(head);
        if(n > length) {
            return head;
        } else if(n == length) {
            return head.next;
        } else {
            ListNode node = getOneLessNNode(head, length - n+1);
            ListNode next = node.next;
            if(next != null) {
                node.next = next.next;
            }
            return head;
        }
    }

    public ListNode getOneLessNNode(ListNode head, int n) {
        ListNode curr = head;
        int length = 1;
        while(curr != null && length < n-1) {
            length++;
            curr = curr.next;
        }
        return curr;
    }

    public int getLength(ListNode head) {
        ListNode curr = head;
        int length = 0;
        while(curr != null) {
            length++;
            curr = curr.next;
        }
        return length;
    }
}
