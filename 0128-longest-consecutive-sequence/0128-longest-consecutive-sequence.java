class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int max = 1;
        int temp = nums[0];
        int curr = 1;
        for(int i=1; i<nums.length; i++){
            if(temp+1 == nums[i]){
                temp = nums[i];
                curr = curr +1;
            }else if(temp == nums[i]){
                continue;
            }
            else{
                temp = nums[i];
                curr = 1;
            }
            max = Math.max(max,curr);
        }
        return max;
    }
}