class Solution {
    int[][] dp = new int[300][300];
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
        int curr=0;
       
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]!='0'){
                    int inner = helper(matrix,i,j);
                    curr = Math.max(curr,inner);
                }
            }
        }
        System.out.println(dp[1][2]);
        return curr*curr;
    }
    public int helper(char[][] matrix, int i, int j){
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length || matrix[i][j]=='0'){
            return 0;
        }
         if(dp[i][j] !=-1) return dp[i][j];
        int ans = Math.min(helper(matrix,i+1,j),Math.min(helper(matrix,i,j+1),helper(matrix,i+1,j+1)));
        return dp[i][j] = ans+1;
    }
}