class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 ) return 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int ans = 1;
        for(int s:set){
            if(!set.contains(s+1)){
                int count = 1;
                while(set.contains(s-1)){
                    count = count+1;
                    s = s-1;
                }
                ans = Math.max(ans,count);
            }
        }
        return ans;
    }
}