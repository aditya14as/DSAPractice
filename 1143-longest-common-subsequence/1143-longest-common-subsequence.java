class Solution {
    public int longestCommonSubsequence(String S1, String S2) {
        int n = S1.length();
        int m = S2.length();
        int[][] dp = new int[n+1][m+1];
            for(int i =0; i<dp.length; i++){
                Arrays.fill(dp[i], -1);
            }
            
        return helper(S1,S2,n,m,dp);
    }
    int helper(String s1, String s2, int n, int m, int[][] dp){
        if(n==0 || m==0) return 0;
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return dp[n][m] = 1+ helper(s1,s2, n-1, m-1,dp);
        }else{
            return dp[n][m] = Math.max( helper(s1,s2, n-1, m, dp) , helper(s1,s2,n, m-1, dp) );
        }
    }
}