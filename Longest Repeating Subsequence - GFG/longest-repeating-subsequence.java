// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String x)
    {
        // code here
        String y=x;
            
            int m = x.length();
            int n = y.length();
            int[][] dp = new int[m+1][n+1];
            for(int i=0; i<dp.length; i++){
                for(int j=0; j<dp[0].length; j++){
                    if(i==0 || j==0){
                        dp[i][j]=0;
                    }
                }
            }

            for(int i=1; i<m+1; i++){
                for(int j=1; j<n+1; j++){
                    if(x.charAt(i-1)==y.charAt(j-1) && i!=j){
                        dp[i][j] = 1+dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i][j-1] , dp[i-1][j]);
                    }
                }
            }
            
            return dp[m][n];
    }
}