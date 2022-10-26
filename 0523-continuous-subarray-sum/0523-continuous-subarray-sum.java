class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        int rem = 0;
        for(int i=0; i<nums.length; i++){
            sum +=nums[i];
            rem = sum%k;
            if(rem<0){
                rem = rem +k;
            }
            if(map.containsKey(rem)){
                if(i-map.get(rem)>=2) return true;
            }else{
                map.put(rem,i);
            }
        }
        return false;
    }
}