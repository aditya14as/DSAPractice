class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates,new ArrayList<>(),target,0);
        return list;
    }
    public void helper(int[] nums,List<Integer> temp, int target, int start){
        if(target==0){
            List<Integer> inList = new ArrayList<>(temp);
            list.add(inList);
            return;
        }
        if(target<0){
            return;
        }
        for(int i=start; i<nums.length; i++){
            if(i>start && nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            helper(nums,temp,target-nums[i],i+1);
            temp.remove(temp.size()-1);
        }
    }
}