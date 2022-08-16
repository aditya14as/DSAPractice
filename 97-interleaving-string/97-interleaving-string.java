class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][][] dp = new Boolean[s1.length()+1][s2.length()+1][s3.length()+1];
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        return helper(s1,s2,s3,0,0,0,dp);
    }
    public boolean helper(String s1, String s2, String s3, int i, int j, int k,Boolean[][][] dp){
        if(i==s1.length() && j==s2.length() && k==s3.length()){
            return true;
        }
        if(dp[i][j][k]!=null){
            return dp[i][j][k];
        }
        boolean flag = false;
        if(i<s1.length() && s1.charAt(i)==s3.charAt(k)){
            flag = flag || helper(s1,s2,s3,i+1,j,k+1,dp);
        }
        if(j<s2.length() && s2.charAt(j)==s3.charAt(k)){
            flag = flag || helper(s1,s2,s3,i,j+1,k+1,dp);
        }
        return dp[i][j][k]=flag;
    }
}