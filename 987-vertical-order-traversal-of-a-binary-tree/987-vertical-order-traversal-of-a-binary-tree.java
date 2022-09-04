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
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Pair rootPair = new Pair(root.val,null,null,0,0);
        drawTree(rootPair,root);
        // display(rootPair);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<=(max-min); i++){
            list.add(new ArrayList<>());
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        getQueue(pq,rootPair);
        getList(pq,list);
        return list;
    }
    public void getList(PriorityQueue<Pair> pq, List<List<Integer>> list){
        while(pq.size()>0){
            Pair rootPair = pq.remove();
            list.get(rootPair.level+(-min)).add(rootPair.val);
        }
    }
    public void getQueue(PriorityQueue<Pair> pq , Pair rootPair){
        if(rootPair == null){
            return;
        }
        pq.add(rootPair);
        getQueue(pq,rootPair.left);
        getQueue(pq,rootPair.right);
    }
    public void drawTree(Pair rootPair,TreeNode root){
        if(root == null){
            return;
        }
        Pair l=null;
        Pair r= null;
        if(root.left != null)
        l = new Pair(root.left.val,null,null,rootPair.level-1,rootPair.vlevel+1);
        if(root.right != null)
        r = new Pair(root.right.val,null,null,rootPair.level+1,rootPair.vlevel+1);
        min = Math.min(min,rootPair.level);
        max = Math.max(max,rootPair.level);
        rootPair.left = l;
        rootPair.right = r;
        drawTree(rootPair.left,root.left);
        drawTree(rootPair.right,root.right);
    }
    public void display(Pair rootPair){
        if(rootPair == null){
            return;
        }
        System.out.println(rootPair.val+"@"+rootPair.level+"@"+rootPair.vlevel);
        display(rootPair.left);
        display(rootPair.right);
    }
}
class Pair implements Comparable<Pair>{
    int val;
    Pair left;
    Pair right;
    int level;
    int vlevel;
    Pair(int val,Pair left, Pair right,int level,int vlevel){
        this.val = val;
        this.left = left;
        this.right = right;
        this.level = level;
        this.vlevel = vlevel;
    }
    public int compareTo(Pair o){    
        if((this.level==o.level) && (this.vlevel == o.vlevel)){
            return this.val - o.val;
        }else if(this.level == o.level) {
            return this.vlevel - o.vlevel;
        }else{
            return this.level-o.level;
        }
    }    
}