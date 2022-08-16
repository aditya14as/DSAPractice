// class Solution {
//     public int maxSubArray(int[] nums) {
//         //DP(On^2)
//         // int[][] dp = new int[nums.length][nums.length];
//         // int ans = Integer.MIN_VALUE;
//         // for(int g=0; g<nums.length; g++){
//         //     for(int i=0,j=g;j<nums.length; i++,j++){
//         //         if(g==0){
//         //             dp[i][j]=nums[i];
//         //         }
//         //         else{
//         //             dp[i][j]=dp[i][j-1]+nums[j];
//         //         }
//         //         ans = Math.max(ans,dp[i][j]);
//         //     }
//         // }
//         // return ans;

//         //Kadabe's Algorithm(O^n)
//         // int ans = Integer.MIN_VALUE;
//         // int sum=0;
//         // for(int i=0; i<nums.length; i++){
//         //     if(sum<0){
//         //         sum=0;
//         //     }
//         //     sum += nums[i];
//         //     ans = Math.max(sum,ans);
//         // }
//         // return ans;

//         //DP O(n)

//         int[] dp = new int[nums.length];
//         int ans = nums[0];
//         dp[0]=nums[0];
//         for(int i=1; i<nums.length; i++){
//             dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
//             ans = Math.max(dp[i],ans);
//         }
//         return ans;
//     }
// }

class Solution {
    private int maxOverall = Integer.MIN_VALUE;

    protected int recurse(int[] nums, int index) {
        int maxSoFar = 0;
        if (index == nums.length - 1) maxSoFar = nums[index]; 
        else maxSoFar = Math.max(nums[index], nums[index] + recurse(nums, index + 1));
        maxOverall = Math.max(maxOverall, maxSoFar);
        return maxSoFar;
    }

    public int maxSubArray(int[] nums) {
        recurse(nums, 0);
        return maxOverall;
    }
}
