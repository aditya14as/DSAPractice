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
    public TreeNode pruneTree(TreeNode root) {
        if(root==null){
            return root;
        }
        TreeNode l = pruneTree(root.left);
        TreeNode r = pruneTree(root.right);
        if(l == null && r ==null && root.val==0){
            return null;
        }
        root.left = l;
        root.right = r;
        return root;
    }
}