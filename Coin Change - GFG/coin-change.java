// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int Arr[] = new int[m];
            for (int i = 0; i < m; i++) Arr[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(Arr, m, n));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int S[], int m, int n) {
        // code here.
        long[][] dp = new long[m+1][n+1];
        for(int i =0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        
        return helper(S,m,n,dp);
    }
    public long helper(int[] arr, int m, int n,long[][] dp){
        if(m==0 && n>0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        if(arr[m-1]<=n){
            return dp[m][n] = helper(arr,m,n-arr[m-1], dp) + helper(arr,m-1,n,dp);
        }else{
            return dp[m][n] = helper(arr,m-1,n,dp);
        }
    }
}