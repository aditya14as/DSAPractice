class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length+1];
        return helper(nums,0,dp);
    }
    public boolean helper(int[] nums,int i, Boolean[] dp){
        if(i>=nums.length-1){
            return true;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        for(int j=nums[i]; j>0; j--){
            if(helper(nums,j+i,dp)){
                dp[i]=true;
                return true;
            }
        }
        dp[i]=false;
        return false;
    }
}