class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp,-1);
       return helper(days,costs,0,dp);
    }
    public int helper(int[] days, int[] costs, int i,int[] dp){
        if(i==days.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int a = costs[0]+helper(days,costs,i+1,dp);
        int seven=binarySearch(days,i,days[i]+6);
        int b = costs[1]+helper(days,costs,seven+1,dp);
        int thirty = binarySearch(days,i,days[i]+29);
        int c = costs[2]+helper(days,costs,thirty+1,dp);
        return dp[i]= Math.min(a,Math.min(b,c));
    }
    public int binarySearch(int[] days, int s, int target){
        int e= days.length-1;
        while(s<=e){
            int m = s+(e-s)/2;
            if(days[m]==target){
                return m;
            }
            if(days[m]<target){
                s = m+1;
            }
            if(days[m]>target){
                e = m-1;
            }
        }
        return e;
    }
}