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

    public int diameterOfBinaryTree(TreeNode root) {
        return Math.max(recurse(root)[1]-1, 0);
    }
    public int[] recurse(TreeNode root) {
        if(root == null) {
            return new int[]{0, 0};
        } else {
            int[] left = recurse(root.left);
            int[] right = recurse(root.right);
            int height = Math.max(left[0], right[0]) + 1;
            int dia = Math.max(Math.max(left[1], right[1]), left[0] + 1 + right[0]);
            System.out.println(root.val + " " + height + " " + dia);
            return new int[]{height, dia};
        }
    }
}
