// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String str)
    {
        // code here
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
        if(isPal(s,i,j)){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            // int temp = helper(s,i,k,dp) + 1 + helper(s,k+1,j,dp);
            int left;
            if(dp[i][k] != -1){
                left = dp[i][k];
            }else{
                dp[i][k] = helper(s,i,k,dp);
                left = dp[i][k];
            }
            int right;
            if(dp[k+1][j] != -1){
                right = dp[k+1][j];
            }else{
                dp[k+1][j] = helper(s,k+1,j,dp);
                right = dp[k+1][j];
            }
            
            int temp = left+right+1;
            ans = Math.min(temp,ans);
        }
        return dp[i][j] = ans;
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