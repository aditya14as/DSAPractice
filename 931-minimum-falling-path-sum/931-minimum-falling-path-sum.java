class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix.length];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
        int min = Integer.MAX_VALUE;
        for(int j=0; j<matrix.length; j++){
            int temp = helper(matrix,0,j,dp);
            min = Math.min(min,temp);
        }
        return min;
    }
    public int helper(int[][] matrix,int i,int j,int[][] dp){
        if(i<0 || j<0 || i>=matrix.length || j>=matrix.length){
            return Integer.MAX_VALUE;
        }
        if(i==matrix.length-1){
            return matrix[i][j];
        }
        if(dp[i][j] !=-1) return dp[i][j];
        
        return dp[i][j] = matrix[i][j]+Math.min(helper(matrix,i+1,j,dp),Math.min(helper(matrix,i+1,j+1,dp),helper(matrix,i+1,j-1,dp)));
    }
}