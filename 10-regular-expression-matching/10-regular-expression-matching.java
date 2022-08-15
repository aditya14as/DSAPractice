class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()][p.length()];
        return helper(s,p,s.length()-1,p.length()-1,dp);
    }
    public boolean helper(String s, String p, int i, int j, Boolean[][] dp){
        if(i<0 && j<0){
            return true;
        }
        if(j<0 && i>=0){
            return false;
        }
        
        if(i<0) return (p.charAt(j) == '*') && helper(s,p,i,j-2,dp);
        
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'){
            return dp[i][j]=helper(s,p,i-1,j-1,dp);
        }
        if(p.charAt(j)=='*'){
            if(s.charAt(i)==p.charAt(j-1) || p.charAt(j-1)=='.'){
                return dp[i][j]=helper(s,p,i-1,j,dp)||helper(s,p,i,j-2,dp);
            }
            return dp[i][j]=helper(s,p,i,j-2,dp);
        }
        return dp[i][j]=false;
    }
}