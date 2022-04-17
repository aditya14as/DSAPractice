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
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[][] dp = new int[1001][1001];
    Solution(){
        for(int i =0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
    }
    static int knapSack(int n, int w, int val[], int wt[])
    {
        // code here
        if(n==0 || w==0){
            return 0;
        }
        if(dp[n][w] != -1){
            return dp[n][w];
        }
        
        if(wt[n-1]>w){
            return dp[n][w] = knapSack(n-1,w,val,wt);
        }else{ //return maximum value after taking a particular element and after ignoring a particular element
                return dp[n][w]=Math.max( val[n-1] + knapSack(n,w-wt[n-1],val,wt) , knapSack(n-1,w,val,wt));
            }
        
    }
}