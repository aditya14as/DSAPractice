class Solution {
    public int minInsertions(String s) {
        Integer[][] dp = new Integer[s.length()][s.length()];
        String str = "";
        for(int i=s.length()-1; i>=0; i--){
            str+=s.charAt(i);
        }
        int a = helper(s,str,0,0,dp);
        
            return s.length()-a;
    }
    public int helper(String a, String b, int i, int j, Integer[][] dp){
        if(i==a.length() || j==b.length()){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        if(a.charAt(i)==b.charAt(j)){
            return dp[i][j] = 1+helper(a,b,i+1,j+1,dp);
        }
        return dp[i][j]=Math.max(helper(a,b,i+1,j,dp),helper(a,b,i,j+1,dp));
    }
}