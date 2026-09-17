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

    public boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        compareHeight(root);
        return isBalanced;
    }

    public int compareHeight(TreeNode root) {
        if(root == null || !isBalanced) {
            return 0;
        } else {
            int left = compareHeight(root.left);
            int right = compareHeight(root.right);        
            if(Math.abs(left - right) > 1) {
                isBalanced = false;
                return 0;
            } else {
                return 1 + Math.max(left, right);
            }
        }
    }
}
