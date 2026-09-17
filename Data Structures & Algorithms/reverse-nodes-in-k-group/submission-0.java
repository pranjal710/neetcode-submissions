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

    private ListNode[] reverse(ListNode head, int k) {
        if(head == null) {
            return null;
        } else if(k == 1) {
            ListNode temp = head.next;
            head.next = null;
            //curr, root, last+1
            return new ListNode[]{head, head, temp};
        } else {
            ListNode[] response = reverse(head.next, k-1);
            if(response == null) {
                return null;
            }
            response[0].next = head;
            head.next = null;
            return new ListNode[]{head, response[1], response[2]};
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = null, last = null;
        while(head != null) {
            ListNode[] response = reverse(head, k);
            if(response == null) {
                // last.next = head;
                if(root == null) {
                    root = head;
                    head = null;
                } else {
                    last.next = head;
                    head = null;
                }
            } else {
            
                if(root == null) {
                    root = response[1];
                } else {
                    last.next = response[1];
                }
                last = head;
                head.next = response[2];
                head = head.next;
            }
        }
        return root;
    }
    
}
