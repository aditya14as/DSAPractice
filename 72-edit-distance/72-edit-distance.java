class Solution {
    public int minDistance(String word1, String word2) {
        Integer[][] dp = new Integer[word1.length()][word2.length()];
        return helper(word1,word2,word1.length()-1,word2.length()-1,dp);
    }
    public int helper(String word1, String word2, int i, int j, Integer[][] dp){
        //If both of them are empty then we get matched
        if(i<0 && j<0){
            return 0;
        }
        //If word1 are empty then for making word2 we just have to add all left out character of word2 
        if(i<0 && j>=0){
            return j+1;
        }
        //If word2 are empty then for making word2 we just have to delete all left out character of word1 
        if(i>=0 && j<0){
            return i+1;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        //If characters in both the words match then operation will be zero
        if(word1.charAt(i)==word2.charAt(j)){
            return dp[i][j]=0+helper(word1,word2,i-1,j-1,dp);
        }
        //If we are inserting in word1 then character from word2 are matched so subtract from j
        int insert = 1+helper(word1,word2,i,j-1,dp);
        //If we are removing from word1 then character from word1 are removed so sutract from i
        int remove = 1 + helper(word1,word2,i-1,j,dp);
        //If we are replacing, both the character of word1 and word2 are matched and hence we are subtracting from both i and j
        int replace = 1+ helper(word1,word2,i-1,j-1,dp);
        //In all the above 3 cases operation will be 1 so we are adding 1 to it
        return dp[i][j]=Math.min(insert,Math.min(remove,replace));
    }
}