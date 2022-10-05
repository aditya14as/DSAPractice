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

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode temp = new TreeNode(val,root,null);
            return temp;
        }
        return dfs(root, val, depth, 1);
    }

    public TreeNode dfs(TreeNode root, int val, int depth, int k) {
        if (root == null) {
            return null;
        }
        if (k == depth - 1) {
            TreeNode ltemp = new TreeNode(val, root.left, null);
            root.left = ltemp;
            TreeNode rtemp = new TreeNode(val, null, root.right);
            root.right = rtemp;
            return root;
        }
        TreeNode left = dfs(root.left, val, depth, k + 1);
        TreeNode right = dfs(root.right, val, depth, k + 1);
        return new TreeNode(root.val, left, right);
    }
}
