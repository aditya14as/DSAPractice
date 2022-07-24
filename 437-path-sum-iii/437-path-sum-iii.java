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
    int ans=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        helper(root,targetSum,0);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return ans;
    }
    public void helper(TreeNode root,int k, long temp){
        if(root==null){
            return;
        }
        temp = temp+root.val;
        if(temp==k){
            ans++;
            
        }
        helper(root.left,k,temp);
        helper(root.right,k,temp);
    }
}