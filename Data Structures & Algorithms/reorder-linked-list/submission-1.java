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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;// head;
        }
        ListNode secondNode = splitList(head);
        //print(secondNode);
        ListNode reverse = reverse(secondNode);
        ListNode newHead = mergeNodes(head, reverse);
        // return newHead;
    }

    public void print(ListNode h) {
        while(h != null) {
            System.out.print(h.val + " ") ;
            h = h.next;
        }
        System.out.println("");
    }

    public ListNode mergeNodes(ListNode h1, ListNode h2) {
        print(h1);
    print(h2);
        if(h1 == null) {
            return h2;
        } else if(h2 == null) {
            return h1;
        } else {
            ListNode head = h1, tail = h1, temp = null;
            
            boolean isH1 = true;
            while(h1 != null && h2 != null) {
                if(isH1) {
                    temp = h1.next;
                    tail.next = h2;
                    tail = h2;
                    h1 = temp;
                } else {
                    temp = h2.next;
                    tail.next = h1;
                    tail = h1;
                    h2 = temp;
                }
                isH1 = !isH1;
            }
            //print(h2);
            tail.next = h2.next;
            return head;
        }
    }

    public ListNode splitList(ListNode head) {
        ListNode sp = head, fp = head, prev = null;
        while(sp != null && fp != null && fp.next != null) {
            prev = sp;
            sp = sp.next;
            fp = fp.next.next;
        }
        prev.next = null;
        return sp;
    }

    public ListNode reverse(ListNode head1) {
        if(head1 == null || head1.next == null) {
            return head1;
        }
        ListNode prev = head1, curr = head1.next, next = head1.next.next;
        prev.next = null;
        while(next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }
}