class Solution {
    int ans = 0;
    public int findLength(int[] nums1, int[] nums2) {
        Integer[][] dp = new Integer[nums1.length][nums2.length];
        helper(nums1,nums2,0,0,dp);
        return ans;
    }
    public int helper(int[] nums1,int[] nums2,int i, int j, Integer[][] dp){
        if(i==nums1.length || j==nums2.length){
            return 0;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        int take = 0;
        if(nums1[i]==nums2[j]){
            take=1+helper(nums1,nums2,i+1,j+1,dp);
            ans = Math.max(ans,take);
        }
        helper(nums1,nums2,i+1,j,dp);
        helper(nums1,nums2,i,j+1,dp);
        return dp[i][j]=take;
    }
}