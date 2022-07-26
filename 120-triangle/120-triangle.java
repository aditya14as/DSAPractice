class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
       return helper(triangle,0,0,dp);
    }
    public int helper(List<List<Integer>> triangle,int i, int l,int[][] dp){
        if(l==triangle.size()-1){
            return (triangle.get(l)).get(i);
        }
        if(l>=triangle.size() || i>=triangle.get(l).size()){
            return Integer.MAX_VALUE;
        }
        if(dp[l][i] != -1){
            return dp[l][i];
        }
        int f = helper(triangle,i,l+1,dp);
        int s = helper(triangle,i+1,l+1,dp);
        return dp[l][i]=Math.min(f,s)+(triangle.get(l)).get(i);
    }
}