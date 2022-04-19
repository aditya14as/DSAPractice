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
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    // } Driver Code Ends


class Solution{

	public int minCoins(int coins[], int n, int v) 
	{ 
	    // Your code goes here
	    int[][] dp = new int[n+1][v+1];
        for(int i =0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
	    int x = helper(coins, n, v, dp);
	    return x==Integer.MAX_VALUE-1 ? -1 : x;
	} 
	public int helper(int[] arr, int n, int v, int[][] dp){
	    if(n==0){
	        return Integer.MAX_VALUE -1;
	    }
	    if(v==0){
	        return 0;
	    }
	    
	    if(n==1){
	        if(v%arr[0] == 0){
	            return v/arr[0];
	        }else{
	            return Integer.MAX_VALUE -1;
	        }
	    }
	    if(dp[n][v] != -1){
	        return dp[n][v];
	    }
	    if(arr[n-1]<=v){
	        return dp[n][v] = Math.min( helper(arr,n,v-arr[n-1], dp) +1 , helper(arr,n-1,v,dp) );
	    }else{
	       return dp[n][v] = helper(arr, n-1, v, dp);
	    }
	}
}