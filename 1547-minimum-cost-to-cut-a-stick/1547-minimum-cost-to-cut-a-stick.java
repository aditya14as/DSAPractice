class Solution {
    public int minCost(int n, int[] cuts) {
        Integer[][] dp = new Integer[cuts.length+1][cuts.length+1];
        int[] nCuts = new int[cuts.length+2];
        nCuts[0]=0;
        nCuts[nCuts.length-1]=n;
        for(int i=0; i<cuts.length; i++){
            nCuts[i+1] = cuts[i];
        }
        Arrays.sort(nCuts);
        return helper(nCuts,1,nCuts.length-2,dp);
    }
    public int helper(int[] cuts,int i,int j,Integer[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<=j; k++){
            int cost = cuts[j+1]-cuts[i-1] + helper(cuts,k+1,j,dp)+helper(cuts,i,k-1,dp);
            ans = Math.min(ans,cost);
        }
        return dp[i][j]=ans;
    }
}