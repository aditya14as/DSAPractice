// { Driver Code Starts


import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        
        int[][] dp = new int[n+1][n+1];
        for(int i =0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(price,n,n,dp);
    }
    public int helper(int[] price, int n, int l, int[][] dp){
        if(n==0 || l==0) return 0;
        if(dp[n][l] != -1){
            return dp[n][l];
        }
        if(n-1<l){
            return dp[n][l] = Math.max(price[n-1] + helper(price,n,l-n,dp) , helper(price,n-1,l,dp));
        }else{
            return dp[n][l] = helper(price,n-1,l,dp);
        }
    }
}