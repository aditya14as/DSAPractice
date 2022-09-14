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
    int count = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        int[] arr = new int[10];
        dfs(root, arr);
        return count;
    }

    public void dfs(TreeNode root, int[] arr) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            arr[root.val]++;
            if (helper(arr)) {
                count++;
            }
            arr[root.val]--;
            return;
        }
        arr[root.val]++;
        dfs(root.left, arr);
        dfs(root.right, arr);
        arr[root.val]--;
    }

    public boolean helper(int[] arr) {
        int oddCount = 0;
        for(int i=0; i<10; i++){
            if(arr[i]%2==1){
                oddCount++;
            }
        }
        if (oddCount == 0 || oddCount == 1) {
            return true;
        }
        return false;
    }
}
