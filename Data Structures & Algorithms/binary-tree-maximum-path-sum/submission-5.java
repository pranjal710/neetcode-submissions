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
    private boolean allNegative(TreeNode root) {
        if(root == null) {
            return true;
        } else if(root.val > 0) {
            return false;
        } else {
            return allNegative(root.left) && allNegative(root.right);
        }
    }

    private int max(TreeNode root) {
        if(root == null) {
            return Integer.MIN_VALUE;
        } else {
            int l = max(root.left);
            int r = max(root.right);
            return Math.max(root.val, Math.max(l, r));
        }
    }

    private int[] dfs(TreeNode root) {
        if(root == null) {
            return new int[]{0,0};
        } else {
            int[] l = dfs(root.left);
            int[] r = dfs(root.right);
            if(root.val > 0) {
                int val = root.val;
                return new int[]{Math.max(Math.max(Math.max(l[0], r[0]), val + Math.max(l[1], r[1])), val + l[1] + r[1]), val + Math.max(l[1], r[1])};
            } else {
                int val = root.val + Math.max(l[1], r[1]);
                val = val < 0 ? 0 : val;
                return new int[]{Math.max(Math.max(Math.max(l[0], r[0]), Math.max(l[1], r[1])), root.val + l[1] + r[1]), val};
            }
            
        }
    }

    public int maxPathSum(TreeNode root) {
        if(root == null) {
            return 0;
        } else if(allNegative(root)) {
            return max(root);
        } else {
            return dfs(root)[0];
        }
    }
}
