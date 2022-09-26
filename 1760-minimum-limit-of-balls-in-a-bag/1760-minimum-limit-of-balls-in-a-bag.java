class Solution {
    public int minimumSize(int[] nums, int maxOp) {
        int start = 1;
        int end = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            end = Math.max(nums[i],end);
        }
        int ans=0;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(valid(mid,nums,maxOp)){
                end = mid-1;
                ans = mid;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
    public boolean valid(int req,int[] nums,int maxOp){
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]%req==0){
                count = count + (nums[i]-1)/req;
            }else{
                count = count + nums[i]/req;
            }
        }
        return count<=maxOp;
    }
}