// { Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} // } Driver Code Ends


//User function Template for Java

class Solution{
    static int countMin(String x)
    {
        // code here
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
            
            return m-dp[m][n];
        
        
    }
}