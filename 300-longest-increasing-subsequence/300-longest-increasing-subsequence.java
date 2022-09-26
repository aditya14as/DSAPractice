class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i=1; i<nums.length; i++){
            if(list.get(list.size()-1)<nums[i]){
                list.add(nums[i]);
            }else{
                int idx = binarySearch(list,0,list.size()-1,nums[i]);
                list.set(idx,nums[i]);
            }
        }
        return list.size();
    }
    public int binarySearch(List<Integer> list, int start, int end, int target){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(list.get(mid)==target){
                return mid;
            }else if(list.get(mid)<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return start;
    }
}