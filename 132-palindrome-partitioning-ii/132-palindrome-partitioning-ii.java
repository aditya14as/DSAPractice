class Solution {
    public int minCut(String str) {
        int n = str.length();
        int[][] dp = new int[n+1][n+1];
            for(int i =0; i<dp.length; i++){
                Arrays.fill(dp[i], -1);
            }
        return helper(str,0,str.length()-1,dp);
    }
    static int helper(String s,int i, int j,int[][] dp){
        if(i>=j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(isPal(s,i,j)){
            return 0;
        }
        
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            // int temp = helper(s,i,k,dp) + 1 + helper(s,k+1,j,dp);
            
//             int left;
//             if(dp[i][k] != -1){
//                 left = dp[i][k];
//             }else{
//                 dp[i][k] = helper(s,i,k,dp);
//                 left = dp[i][k];
//             }
//             int right;
//             if(dp[k+1][j] != -1){
//                 right = dp[k+1][j];
//             }else{
//                 dp[k+1][j] = helper(s,k+1,j,dp);
//                 right = dp[k+1][j];
//             }
            
//             int temp = left+right+1;
//             ans = Math.min(temp,ans);
            if (isPal(s, i, k)) {
				int ans2 = 1 + helper(s, k + 1, j, dp);
				ans = Math.min(ans, ans2);
				dp[i][j] = ans;
			}
        }
        return ans;
    }
    
    static boolean isPal(String s,int i, int j){
        if(i==j){
            return true;
        }
        while(j>i){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            
            }
            i++;
            j--;
        }
        return true;
    }
}