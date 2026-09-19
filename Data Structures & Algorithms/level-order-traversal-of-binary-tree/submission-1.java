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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        bfs(res, Arrays.asList(root));
        return res;
    }

    private void bfs(List<List<Integer>> res, List<TreeNode> curr) {
        fillResWithCurrent(res, curr);
        List<TreeNode> children = getListOfChildren(curr);
        if(children.size() == 0) {
            return;
        } else {
            bfs(res, children);
        }
    }

    private List<TreeNode> getListOfChildren(List<TreeNode> curr) {
        List<TreeNode> res = new ArrayList<>();
        for(TreeNode node : curr) {
            addToRes(res, node);
        }
        return res;
    }

    private void addToRes(List<TreeNode> res, TreeNode node) {
        if(node.left != null) {
            res.add(node.left);
        }
        if(node.right != null) {
            res.add(node.right);
        }
    }

    private void fillResWithCurrent(List<List<Integer>> res, List<TreeNode> curr) {
        res.add(curr.stream().map(node -> node.val).collect(Collectors.toList()));
    }
}
