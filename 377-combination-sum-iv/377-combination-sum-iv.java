class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[][] dp = new int[nums.length][target+1];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(nums,target,0,dp);
    }
    public int helper(int[] nums, int target, int i, int[][] dp){
        if(target==0){
            return 1;
        }
        if(target<0 || i>=nums.length){
            return 0;
        }
        if(dp[i][target] != -1){
            return dp[i][target];
        }
        int notTake = helper(nums,target,i+1,dp);
        int take = helper(nums,target-nums[i],0,dp); 
        return dp[i][target] = notTake+take;
    }
}