class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        int jump=nums[0];
        if(jump==0) return false;
        
        for(int i=1; i<nums.length-1; i++){
            jump--;
            if(jump<nums[i]){
                jump=nums[i];
            }
            if(jump<=0){
                return false;
            }
        }
        return true;
    }
}