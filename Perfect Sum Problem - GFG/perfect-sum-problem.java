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
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    // } Driver Code Ends


class Solution{
    static int M= 1000000007;
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int[][] dp = new int[n+1][sum+1];
	    for(int i =0; i<dp.length; i++){
	        Arrays.fill(dp[i],-1);
	    }
	    return solve(arr,n,sum,dp);
	}
	public int solve(int[] arr, int n, int sum, int[][] dp){
	    if(n==0 && sum==0){  // if sum is equal to zero then answer would be 1 because we can take empty set
            return 1;
        }
        if(n==0){
            return 0;
        }
        
	    if(dp[n][sum] != -1){
	        return dp[n][sum]%M;
	    }
	    
	    if(arr[n-1]>sum){
	        return dp[n][sum]= solve(arr,n-1,sum,dp)%M;
	    }else{
	        return dp[n][sum] = (solve(arr,n-1,sum-arr[n-1],dp)%M + solve(arr,n-1,sum,dp)%M) % M;
	    }
	    
	}
}