class Solution {
    List<Integer> ans;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] dp = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        ans = new ArrayList<>();
        helper(nums, 0,-1, dp,list);
        // System.out.println(ans);
        
        return ans;
    }

    public void helper(int[] nums, int i, int prev, int[] dp,List<Integer> list) {
        
        if (i == nums.length) {
           if(ans.size()<list.size()){
                ans.clear();
                ans.addAll(list);
            }
            return;
        }
        
        
        
        int taken = Integer.MIN_VALUE;
        if (prev==-1 || (nums[i]%nums[prev] == 0 && list.size()>dp[i])) {
            dp[i]=list.size();
            list.add(nums[i]);
            helper(nums, i + 1, i, dp,list);
            int s = list.size()-1;
            list.remove(s);
        }
        helper(nums, i + 1, prev, dp,list);
        
        return;
    }
}
