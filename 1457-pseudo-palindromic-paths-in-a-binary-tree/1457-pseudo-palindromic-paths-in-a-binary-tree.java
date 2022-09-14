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
        HashMap<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        return count;
    }

    public void dfs(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            if (helper(map)) {
                count++;
            }
            if (map.get(root.val) == 1) {
                map.remove(root.val);
            } else {
                map.put(root.val, map.get(root.val) - 1);
            }
            return;
        }
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        dfs(root.left, map);
        dfs(root.right, map);
        if (map.get(root.val) == 1) {
            map.remove(root.val);
        } else {
            map.put(root.val, map.get(root.val) - 1);
        }
    }

    public boolean helper(HashMap<Integer, Integer> map) {
        int oddCount = 0;
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            // Printing all elements of a Map
            // System.out.println(set.getKey() + " = "
            //                    + set.getValue());
            if (set.getValue() % 2 == 1) {
                oddCount++;
            }
        }
        if (oddCount == 0 || oddCount == 1) {
            return true;
        }
        return false;
    }
}
