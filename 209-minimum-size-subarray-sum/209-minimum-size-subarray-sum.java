class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       int[] pre = new int[nums.length];
        pre[0]=nums[0];
        for(int i=1; i<nums.length; i++){
            pre[i]=nums[i]+pre[i-1];
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<pre.length; i++){
            if(pre[i]==target){
                ans = Math.min(ans,i+1);
            }else if(pre[i]>target){
                int key = pre[i]-target;
                int idx = binarySearch(pre,key,i-1);
                ans = Math.min(ans,i-idx);
            }
        }
        if(ans==Integer.MAX_VALUE) return 0;
        return ans;
    }
    public int binarySearch(int[] pre,int target,int high){
        int low = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(pre[mid]==target){
                return mid;
            }else if(pre[mid]>target){
                high=mid-1;
            }else{
                low = mid+1;
            }
        }
        return low-1;
    }
}