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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode l : lists) {
            queue.add(l);
        }
        ListNode head = null, temp = null;
        while(queue.size() > 0) {
            ListNode node = queue.remove();
            if(head == null) {
                head = node;
                temp = head;
            } else {
                temp.next = node;
                temp = node;
            }
            if(node.next != null) {
                queue.add(node.next);
            }
        }
        return head;
    }
}
