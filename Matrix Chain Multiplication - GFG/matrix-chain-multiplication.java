// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int n, int arr[])
    {
        // code here
        int[][] dp = new int[n+1][n+1];
            for(int i =0; i<dp.length; i++){
                Arrays.fill(dp[i], -1);
            }
        return helper(arr,1,n-1,dp);
    }
    static int helper(int[] arr, int i,int j,int[][] dp){
        if(i==j) return 0;
        int ans = Integer.MAX_VALUE;
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        for(int k=i; k<j; k++){
            int temp = helper(arr,i,k,dp)+helper(arr,k+1,j,dp)+arr[i-1]*arr[k]*arr[j];
            if(temp<ans){
                ans = temp;
            }
        }
        return dp[i][j] = ans;
    }
}