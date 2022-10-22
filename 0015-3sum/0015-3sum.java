class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length;){
            for(int j=i+1; j<nums.length;){
                int target = 0 - (nums[i]+nums[j]);
                int idx = Arrays.binarySearch(nums,j+1,nums.length,target);
                if(idx>=0){
                    List<Integer> inList = new ArrayList<>();
                    inList.add(nums[i]);
                    inList.add(nums[j]);
                    inList.add(target);
                    list.add(inList);
                }
                j++;
                while(j<nums.length && nums[j]==nums[j-1]){
                    j++;
                }
            }
            i++;
            while(i<nums.length-2 && nums[i]==nums[i-1]){
                i++;
            }
        }
        return list;
    }
}