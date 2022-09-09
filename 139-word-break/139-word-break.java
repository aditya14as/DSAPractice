class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()+1];
         HashSet<String> set = new HashSet<>(wordDict);
        return helper(s,set,0,s.length(),dp);
        
    }
    public boolean helper(String s, HashSet<String> set,int i, int n,Boolean[] dp){
        if(i==n){
            return true;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        
        for(int k=i; k<n; k++){
            
            //Method-1
             if(set.contains(s.substring(i,k+1))&& helper(s,set,k+1,n,dp)){
                 dp[i]=true;
                 return true;
             }
            
            //Method-2
            // return dp[i]=(set.contains(s.substring(i,k+1)) && helper(s,set,k+1,n,dp));
        }
        return dp[i]=false;
    }
}