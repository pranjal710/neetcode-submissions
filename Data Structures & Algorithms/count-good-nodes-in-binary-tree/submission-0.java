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
    public int goodNodes(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int[] total = new int[]{0};
            dfs(root, total, root.val-1);
            return total[0];
        }
    }

    public void dfs(TreeNode root, int[] total, int max) {
        if(root == null) {
            return;
        } else {
            if(root.val >= max) {
                total[0]++;
            }
            dfs(root.left, total, Math.max(max, root.val));
            dfs(root.right, total, Math.max(max, root.val));
        }
    }
}
