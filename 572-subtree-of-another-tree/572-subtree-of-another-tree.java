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
    public boolean ans = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
       if(root!=null){
           isSubtree(root.left,subRoot);
           boolean temp = isMatch(root,subRoot);
           if(temp){
               ans = true;
           }
           isSubtree(root.right,subRoot);
       }
        return ans;
    }
    
    public boolean isMatch(TreeNode a, TreeNode b){
        if(a!=null && b!=null){
            boolean lc = isMatch(a.left, b.left);
            boolean rc = isMatch(a.right, b.right);
            if(a.val == b.val && lc && rc){
                return true;
            }else{
                return false;
            }
        }else if(a==null && b==null){
            return true;
        }else{
            return false;
        }
        
    }
    
                    
}