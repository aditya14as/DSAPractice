class Solution {
    Integer[][] dp;
    public int maximumScore(int[] nums, int[] multipliers) {
        int N = nums.length;
        int M = multipliers.length;
        if (N >= M * 2) {
            int[] newNums = new int[M * 2];
            System.arraycopy(nums,0,newNums,0, M);
            System.arraycopy(nums,N - M,newNums,M, M);
            nums = newNums;
        }
        dp = new Integer[nums.length][nums.length];
        return helper(nums,multipliers,0,nums.length-1,0);
    }
    public int helper(int[] nums,int[] mul,int i, int j, int k){
        if(k==mul.length){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int f = nums[i]*mul[k]+helper(nums,mul,i+1,j,k+1);
        int s = nums[j]*mul[k]+helper(nums,mul,i,j-1,k+1);
        return dp[i][j]=Math.max(f,s);
    }
}