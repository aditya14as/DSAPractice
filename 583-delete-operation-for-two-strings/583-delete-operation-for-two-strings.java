class Solution {
    public int minDistance(String word1, String word2) {
        Integer[][] dp = new Integer[word1.length()][word2.length()];
        return helper(word1,word2,word1.length()-1,word2.length()-1,dp);
    }
    public int helper(String word1, String word2, int i, int j, Integer[][] dp){
        if(i<0 && j<0){
            return 0;
        }
        if(i<0 && j>=0){
            return j+1;
        }
        if(i>=0 && j<0){
            return i+1;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        if(word1.charAt(i)==word2.charAt(j)){
            return dp[i][j]=helper(word1,word2,i-1,j-1,dp);
        }
        int delete1 = 1+helper(word1,word2,i,j-1,dp);
        int delete2 = 1 + helper(word1,word2,i-1,j,dp);
        
        return dp[i][j]=Math.min(delete1,delete2);
    }
}