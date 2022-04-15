// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum = 0; 
        for(int i=0; i<arr.length; i++){
            sum+= arr[i];
        }
        if(sum%2!=0){
            return 0;
        }else{
            int[][] dp= new int[N+1][sum/2+1];
            for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
            }
            return solve(N,arr,sum/2,dp);
        }
    }
    
    static int solve(int n, int arr[], int sum,int[][] dp){
            if(n==0 && sum==0){  // if sum is equal to zero then answer would be 1 because we can take empty set
                return 1;
            }
            if(sum==0){
                return 1;
            }
            if(n==0 && sum!=0){ // if n == 0 means no item in arr but sum is not equal to zero then it's not possible to create
                                // that array with sum greater than 0
                return 0;
            }
            if(dp[n][sum] !=-1){
                return dp[n][sum];
            }


            if(arr[n-1]>sum){ // If element of array is greater than sum then we can't take that element in the sum by any means
                dp[n][sum] = solve(n-1,arr,sum,dp);
                return dp[n][sum];
            }else{
                int a = solve(n-1, arr, sum-arr[n-1],dp); // Taking that element in the sum
                int b = solve(n-1, arr, sum,dp); // Not taking that element in the sum
                if(a==1 || b==1){   // if any of the options is returning true then whole answer would be true
                    return dp[n][sum]=1;
                }else{
                    return dp[n][sum]=0;
                }
            }
        }
}