// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[][] dp = new int[101][100001];
        Solution(){
            for(int i =0;i<dp.length; i++){
                Arrays.fill(dp[i],-1);
            }
        }

    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int a = solve(N,arr,sum);
        if(a==0){
            return false;
            
        }
        else{
            return true;
        }
    }
    static int solve(int n, int arr[], int sum){
        if(n==0 && sum==0){
            return 1;
        }
        if(sum==0){
            return 1;
        }
        if(n==0 && sum!=0){
            return 0;
        }
        if(dp[n][sum] !=-1){
                return dp[n][sum];
        }
            
        
        if(arr[n-1]>sum){
            return dp[n][sum] = solve(n-1,arr,sum);
        }else{
            int a = solve(n-1, arr, sum-arr[n-1]);
            int b = solve(n-1, arr, sum);
            if(a==1 || b==1){
               return dp[n][sum]=1;
            }else{
                return dp[n][sum]=0;
            }
        }
    }
}