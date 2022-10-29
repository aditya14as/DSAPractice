class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums,new ArrayList<>(),0);
        return list;
    }
    public void helper(int[] nums,List<Integer> temp, int i){
        list.add(new ArrayList<>(temp));
        for(int j = i; j<nums.length; j++){
            temp.add(nums[j]);
            helper(nums,temp,j+1);
            temp.remove(temp.size()-1);
        }
    }
}