/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<TreeNode> path = nodeToRoot(root,target);
        for(int i=0; i<path.size(); i++){
            levelDown(path.get(i),k-i,i==0? null : path.get(i-1));
        }
        return list;
    }
    public void levelDown(TreeNode root,int k, TreeNode blocker){
        if(root==null || root==blocker || k<0){
            return;
        }
        if(k==0){
            list.add(root.val);
        }
        levelDown(root.left,k-1,blocker);
        levelDown(root.right,k-1,blocker);
    }
    
    public List<TreeNode> nodeToRoot(TreeNode root,TreeNode target){
        if(root==null){
            return new ArrayList<>();
        }
        if(root==target){
            List<TreeNode> path = new ArrayList<>();
            path.add(root);
            return path;
        }
        if(root.left!=null){
            List<TreeNode> ll = nodeToRoot(root.left,target);
            if(ll.size()>0){
                ll.add(root);
                return ll;
            }
        }
        if(root.right!=null){
            List<TreeNode> rl = nodeToRoot(root.right,target);
            if(rl.size()>0){
                rl.add(root);
                return rl;
            }
        }
        return new ArrayList<>();
    }
    
}