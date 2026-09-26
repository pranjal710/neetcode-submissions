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
    public int kthSmallest(TreeNode root, int k) {
        int[] res = new int[]{-1};
        recurse(root, k, 1, res, true);
        return res[0];
    }

    private int recurse(TreeNode root, int k, int curr, int[] res, boolean isLeft) {
        
        if(root == null || res[0] >= 0) {
            return curr-1 - (isLeft ? 0 : 1);
        } else {
            // System.out.println("Start-->" + root.val + " " + k + " " + curr + " " + res[0]);
            int lowest = recurse(root.left, k, curr, res, true);
            if(res[0] < 0 && k == lowest+1) {
                res[0] = root.val;
            }
            return Math.max(lowest+1, recurse(root.right, k, lowest+2, res, false));        }
        
    }
}
