class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Integer.MIN_VALUE;
        for(int i=0; i<piles.length; i++){
            end=Math.max(piles[i],end);
        }
        int ans = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(valid(piles,mid,h)){
                end = mid-1;
                ans = mid;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
    public boolean valid(int[] piles,int mid, int h){
        long count = 0;
        for(int i=0; i<piles.length; i++){
            if(piles[i]%mid==0){
                count += (piles[i]/mid);
            }else{
                count += ((piles[i]/mid)+1);
            }
        }
        return count<=h;
    }
}