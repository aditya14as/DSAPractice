class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans =0;
        int sum =0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        // We need to add zero frequency as 1 because it will give zero ans if sum -k = 0 occurs at first time
        map.put(0,1);
        for(int i=0; i<nums.length; i++){
            sum = sum+ nums[i];
            
            //if map contains sum-k. it means total no of items passed between sum and sum-k indexes has sum k.
            if(map.containsKey(sum-k)){
                ans=ans+map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}