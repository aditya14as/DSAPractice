class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum =0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }
        int s= (sum+target)/2;
        if(sum+target<0 || (sum+target)%2 ==1) return 0;
        int[][] dp = new int[nums.length+1][s+1];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(nums,s,nums.length,dp);
    }
    
    public int solve(int[] arr, int sum,int n,int[][] dp){
        if(n==0 && sum==0){
            return 1;
        }
        if(n==0){
            return 0;
        }
        if(dp[n][sum] != -1){
            return dp[n][sum];
        }
        if(arr[n-1]>sum){
            return dp[n][sum] = solve(arr,sum,n-1, dp);
        }else{
            return dp[n][sum] = solve(arr,sum,n-1,dp) + solve(arr,sum-arr[n-1],n-1,dp);
        }
    }
}