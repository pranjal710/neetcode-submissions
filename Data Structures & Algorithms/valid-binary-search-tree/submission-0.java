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
    public boolean isValidBST(TreeNode root) {
        boolean[] result = new boolean[]{true};
        getMinMax(root, result);
        return result[0];
    }

    private int[] getMinMax(TreeNode root, boolean[] result) {
        if(root == null || !result[0]) {
            return null;
        } else {
            int[] left = getMinMax(root.left, result);
            int[] right = getMinMax(root.right, result);
            result[0] = result[0] && (left == null || (root.val > left[0] && root.val > left[1] && root.val > root.left.val))
            && (right == null || (root.val < right[0] && root.val < right[1] && root.val < root.right.val));
            return new int[]{left == null ? root.val : left[0], right == null ? root.val : right[1]};
        }
    }
}
