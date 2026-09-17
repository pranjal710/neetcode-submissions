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
        int[] val = new int[]{-1};
        func(root, k, new int[]{0}, val);
        return val[0];
    }


    public void func(TreeNode root, int k, int[] count, int[] val) {
        
        if(root == null || val[0] != -1) {
            return ;
        } else {
            func(root.left, k, count, val);
            count[0]++;
            if(count[0] == k) {
               val[0] = root.val;
               return;
            }
            func(root.right, k, count, val);
            return;
        }
        
        

    
    }

}
