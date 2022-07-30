class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length];
        return helper(nums,0,-1,dp);
    }
    public int helper(int[] nums,int i,int prev, Integer[][] dp){
        if(i==nums.length){
            return 0;
        }
        if(prev!= -1 && dp[i][prev]!=null){
            return dp[i][prev];
        }
        int notTaken = helper(nums,i+1,prev,dp);
        int taken = Integer.MIN_VALUE;
        if(prev == -1 || nums[prev]<nums[i]){
            taken = 1 + helper(nums,i+1,i,dp);
        }
       int value = Math.max(taken,notTaken);
        if(prev!=-1){
            dp[i][prev] = value;
            return dp[i][prev];
        }
        return value;
    }
}