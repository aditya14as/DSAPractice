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
class DiaPair{
    int height;
    int diameter;
    DiaPair(int height, int diameter){
        this.height = height;
        this.diameter = diameter;
    }
}

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        // if(root==null){
        //     return -1;
        // }
        // int ld = diameterOfBinaryTree(root.left);
        // int rd = diameterOfBinaryTree(root.right);
        // int f = height(root.left) + height(root.right)+2;
        // return Math.max(ld,Math.max(f,rd));
        DiaPair dp = helper(root);
        return dp.diameter;
        
    }
    public DiaPair helper(TreeNode root){
        if(root==null){
            DiaPair dp = new DiaPair(-1,-1);
            return dp;
        }
        DiaPair lp = helper(root.left);
        DiaPair rp = helper(root.right);
        int height = Math.max(lp.height,rp.height)+1;
        int temp = lp.height + rp.height + 2;
        int diameter = Math.max(lp.diameter,Math.max(rp.diameter,temp));
        return new DiaPair(height,diameter);
    }
    
//     public int height(TreeNode root){
//         if(root==null){
//             return -1;
//         }
//         int lh = height(root.left);
//         int rh = height(root.right);
//         return (Math.max(lh,rh)+1);
        
    }