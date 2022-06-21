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
    String ans="";
    List<String> list = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        helper(root,"");
        return list;
    }
    public void helper(TreeNode root, String path){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            path=path+root.val;
            list.add(path);
        } 
        
        helper(root.left,path+root.val+"->");
        helper(root.right,path+root.val+"->");
        
    }
}