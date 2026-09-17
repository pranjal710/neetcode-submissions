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
        int[] max = new int[]{root.val};
        recurse(root, max);
        return max[0];
    }

    public int[] recurse(TreeNode root, int[] max) {
        if(root == null) {
            return null;
        } else {
            int[] left = recurse(root.left, max);
            int[] right = recurse(root.right, max);
            setMax(max, left, right, root);
            System.out.println(max[0] + " " + (root == null ? "*" : root.val));
            return deriveMax(left, right, root);
        }
    }

    private void setMax(int[] max, int[] left, int[] right, TreeNode root) {
        int localMax[] = deriveMax(left, right, root);
        max[0] = Math.max(localMax[1], Math.max(max[0], localMax[0]));
    }

    private int[] deriveMax(int[] left, int[] right, TreeNode root) {
        int leftMax = left != null ? Math.max(left[0] + root.val, root.val) : root.val;
        int rightMax = right != null ? Math.max(right[0] + root.val, root.val) : root.val;
        int centerMax = left != null && right != null ? Math.max(right[0] + left[0] + root.val, root.val) : root.val;
        return new int[]{Math.max(leftMax, rightMax), centerMax};
    }
}
