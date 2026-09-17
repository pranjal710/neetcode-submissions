/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxPathSum(TreeNode root) {
        int[] res = recurse(root);
        return res[1];
    }

    private int[] recurse(TreeNode root) {
        if(root == null) {
            return new int[]{0, -20000};
        } else {
            int[] l = recurse(root.left);
            int[] r = recurse(root.right);
            int max = Math.max(l[1], r[1]);
            max = Math.max(max, root.val+l[0]);
            max = Math.max(max, root.val+r[0]);
            max = Math.max(max, root.val+r[0]+l[0]);
            int localMax = Math.max(root.val+l[0], root.val+r[0]);
            localMax = Math.max(root.val, localMax);
            max = Math.max(max, localMax);
            return new int[]{localMax, max};
        }
    }
}
