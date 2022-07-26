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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> f = nodeToRoot(root,p);
        List<TreeNode> r = nodeToRoot(root,q);
        int i= f.size()-1;
        int j= r.size()-1;
        while(i>=0 && j>=0 && f.get(i)==r.get(j)){
            i--;
            j--;
        }
        return f.get(i+1);
    }
    public List<TreeNode> nodeToRoot(TreeNode root, TreeNode node){
        if(root==null){
            return new ArrayList<>();
        }
        if(root==node){
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            return list;
        }
        if(root.left!=null){
            
        }
        List<TreeNode> ll = nodeToRoot(root.left, node);
        if(ll.size()>0){
            ll.add(root);
            return ll;
        }
        List<TreeNode> rl = nodeToRoot(root.right, node);
        if(rl.size()>0){
            rl.add(root);
            return rl;
        }
        return new ArrayList<>();
    }
}