class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k+1][n+1];
            for(int i =0; i<dp.length; i++){
                Arrays.fill(dp[i], -1);
            }
	    return solve(k,n,dp);
    }
    static int solve(int e, int f, int[][] dp){
	    if(f==0 || f==1){
	        return f;
	    }
	    if(e==1){
	        return f;
	    }
	    if(dp[e][f] != -1){
	        return dp[e][f];
	    }
	    int ans = Integer.MAX_VALUE;
	    int low = 1; 
        int hi = f;
        while(low<hi){
            int mid = (low+hi) /2;
            //if breaks at mid
            int val1 = solve(e-1,mid-1,dp);
            
            //if not breaks at mid
            int val2 = solve(e,f-mid,dp);
            int temp = 1+Math.max(val1,val2);
            if(val1>val2){
                hi=mid;
            }else{
                low = mid+1;
            }
            
            ans = Math.min(ans,temp);
            
        }
        
        
	    return dp[e][f] = ans;
	} 
}