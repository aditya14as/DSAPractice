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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int count = 1;
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(q.size()>0){
           int n= q.size();
            for(int i=0; i<n; i++){
                TreeNode node = q.remove();
                list.add(node.val);
                    if(node.left!=null){
                        q.add(node.left);
                    }
                    if(node.right!=null){
                        q.add(node.right);
                    }
            }
           if(count%2==1){
               ans.add(list);
           }else{
               Collections.reverse(list);
               ans.add(list);
           }
            count++;
            list = new ArrayList<>();
        }
        return ans;
    }
}