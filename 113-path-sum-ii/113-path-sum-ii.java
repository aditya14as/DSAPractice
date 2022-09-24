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
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
       List<Integer> list = new ArrayList<>();
        dfs(root,targetSum,list);
        return ans;
    }
    public void dfs(TreeNode root, int target, List<Integer> list){
        if(root==null){
            return;
        }
        if(root.left == null && root.right==null){
            if(root.val==target){
                list.add(root.val);
                ans.add(new ArrayList<>(list));
                list.remove(list.size()-1);
                return;
            }
        }
        list.add(root.val);
        dfs(root.left,target-root.val,list);
        dfs(root.right,target-root.val,list);
        list.remove(list.size()-1);
    }
}