class Solution {
    public int maxSubArray(int[] nums) {
        // int[][] dp = new int[nums.length][nums.length];
        // int ans = Integer.MIN_VALUE;
        // for(int g=0; g<nums.length; g++){
        //     for(int i=0,j=g;j<nums.length; i++,j++){
        //         if(g==0){
        //             dp[i][j]=nums[i];
        //         }
        //         else{
        //             dp[i][j]=dp[i][j-1]+nums[j];
        //         }
        //         ans = Math.max(ans,dp[i][j]);
        //     }
        // }
        // return ans;
        int ans = Integer.MIN_VALUE;
        int sum=0;
        for(int i=0; i<nums.length; i++){
            if(sum<0){
                sum=0;
            }
            sum += nums[i];
            ans = Math.max(sum,ans);
        }
        return ans;
    }
}