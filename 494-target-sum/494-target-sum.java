class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        int s =0;
        for(int i=0; i<arr.length; i++){
            s+=arr[i];
        }
        int sum= (s+target)/2;
        
        if(s+target<0 || (s+target)%2==1){
            return 0;
        }
        int n = arr.length;
        int[][] t = new int[n+1][sum+1];
        
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0){
                    t[i][j] = 0;
                }
                if(j==0){
                    t[i][j] = 1;
                }
            }
        }
        
        // 'j' started from zero to handle multiple zeros input edge case
        for(int i=1;i<n+1;i++){
            for(int j=0;j<sum+1;j++){  // point 3.
                if(arr[i-1]<= j){
                    t[i][j] = t[i-1][j] + t[i-1][j-arr[i-1]];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
        return t[n][sum];
    }
    
}