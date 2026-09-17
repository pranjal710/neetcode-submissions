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
    private String getHash(TreeNode subRoot) {
        if(subRoot == null) {
            return null;
        } else {
            return getHash(subRoot.left) + subRoot.val + getHash(subRoot.right);
        }

    }

    private String recurse(TreeNode root, String hash, boolean[] res) {
        String currHash = "";
        if(root == null || res[0]) {
            currHash = "null";
        } else {
            currHash = recurse(root.left, hash, res) + root.val + recurse(root.right, hash, res);
            
        }
        res[0] = res[0] || currHash.equals(hash);
        return currHash;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String hash = getHash(subRoot);
        boolean[] res = new boolean[]{false};
        recurse(root, hash, res);
        return res[0];
    }
}
