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
       
      List<TreeNode> list1 =   rootToNode(root,p);
        List<TreeNode> list2 = rootToNode(root,q);
        int i = list1.size()-1;
        int j= list2.size()-1;
        while(i>=0 && j>=0 && list1.get(i)==list2.get(j)){
            i--;
            j--;
        }
        i++;
        
        return list1.get(i);
        
    }
    public ArrayList<TreeNode> rootToNode(TreeNode root, TreeNode p){
        if(root==p) {
		ArrayList<TreeNode> node = new ArrayList<>();
		node.add(root);
		return node;
	}

	if(root.left!=null){
		ArrayList<TreeNode> node = rootToNode(root.left,p);
		if(node.size()>0){
			node.add(root);
			 return node;
		}

	}

	if(root.right!=null){
		ArrayList<TreeNode> node = rootToNode(root.right,p);
		if(node.size()>0){
			node.add(root);
			return node;
		}

	}

	return new ArrayList<>();
    }
}