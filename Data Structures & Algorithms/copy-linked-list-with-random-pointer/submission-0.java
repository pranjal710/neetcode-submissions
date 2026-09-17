/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> cloneMap = new HashMap<>();
        Node curr = head;
        while(curr != null) {
            cloneMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while(curr != null) {
            Node currClone = cloneMap.get(curr);
            if(curr.next != null) {
                Node currNextclone = cloneMap.get(curr.next);
                currClone.next = currNextclone;
            }
            if(curr.random != null) {
                Node currRandomclone = cloneMap.get(curr.random);
                currClone.random = currRandomclone;
            }
            curr = curr.next;
        }
        return cloneMap.get(head);
    }
}
