class Solution {
    
    public int findMaxForm(String[] strs, int m, int n) {
       int[][][] memo = new int[m + 1][n + 1][strs.length + 1];
        int[][] arr = new int[strs.length][2];
        for(int i=0; i<strs.length; i++){
            arr[i] = count(strs[i]);
        }
        
        return helper(arr,m,n,0,memo);
        
    }
    public int helper(int[][] arr,int m, int n, int i, int[][][] memo){
        if (memo[m][n][i] != 0) return memo[m][n][i];
        if(m==0 && n==0){
            return 0;
        }
        if(i==arr.length || m<0 || n<0){
            return 0;
        }
        
        if((arr[i][0]>m) || (arr[i][1]>n)){
            return memo[m][n][i] = helper(arr,m,n,i+1,memo);
             
        }else{
            int take = helper(arr,m-arr[i][0],n-arr[i][1],i+1,memo);
            int notTake = helper(arr,m,n,i+1,memo);
            return memo[m][n][i] = Math.max(take+1,notTake);
        }
        
    }
    public int[] count(String s){
        int ones=0, zeros=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='0')
                zeros++;
            else
                ones++;
        }
        
        return new int[]{zeros,ones};
    }
}