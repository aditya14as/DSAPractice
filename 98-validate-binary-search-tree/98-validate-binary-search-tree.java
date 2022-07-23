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
class Pair{
    long max;
    long min;
    boolean isBST;
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        Pair ans = helper(root);
        return ans.isBST;
    }
    public Pair helper(TreeNode root){
        if(root==null){
            Pair p = new Pair();
            p.max =Long.MIN_VALUE;
            p.min = Long.MAX_VALUE;
            p.isBST = true;
            return p;
        }
        Pair lp = helper(root.left);
        Pair rp = helper(root.right);
        Pair mp = new Pair();
        mp.max = Math.max(lp.max,Math.max(rp.max,root.val));
        mp.min = Math.min(lp.min,Math.min(rp.min,root.val));
        mp.isBST = (lp.isBST && rp.isBST && (lp.max<root.val && rp.min > root.val));
        return mp;
    }
}