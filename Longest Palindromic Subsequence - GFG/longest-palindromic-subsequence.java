// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String x)
    {
        //code here
        String y="";
        for(int i=x.length()-1; i>=0; i--){
            y=y+x.charAt(i);
        }
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
                    if(x.charAt(i-1)==y.charAt(j-1)){
                        dp[i][j] = 1+dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i][j-1] , dp[i-1][j]);
                    }
                }
            }
            
            return dp[m][n];
    }
}