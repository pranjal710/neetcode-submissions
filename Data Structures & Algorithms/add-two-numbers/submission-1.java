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

    private ListNode[] reverse(ListNode l) {
        return new ListNode[]{l, l};
        // if(l == null) {
        //     return null;
        // } else {
        //     ListNode[] res = reverse(l.next);
        //     if(res == null) {
        //         return new ListNode[]{l, l}; //head, curr
        //     } else {
        //         res[1].next = l;
        //         l.next = null;
        //         res[1] = l;
        //         return res;
        //     }
        // }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = reverse(l1)[0];
        ListNode r2 = reverse(l2)[0];
        int carry = 0;
        ListNode curr = null, head = null;
        while(r1 != null || r2 != null) {
            int num1 = getNumber(r1);
            int num2 = getNumber(r2);
            int sum = num1 + num2 + carry;
            carry = sum/10;
            ListNode temp = new ListNode(sum%10);
            ListNode[] references = updateReferences(head, curr, temp);
            head = references[0];
            curr = references[1];
            r1 = getNext(r1);
            r2 = getNext(r2);
        }
        if(carry != 0) {
            ListNode[] references = updateReferences(head, curr, new ListNode(carry));
        }
        return reverse(head)[0];
    }

    private ListNode[] updateReferences(ListNode head, ListNode curr, ListNode temp) {
        if(head == null) {
            head = temp;
            curr = temp;
        } else {
            curr.next = temp;
            curr = temp;
        }
        return new ListNode[]{head, curr};
    }

    private int getNumber(ListNode l) {
        return l == null ? 0 : l.val;
    }

    private ListNode getNext(ListNode l) {
        return l == null ? null : l.next;
    }
}
