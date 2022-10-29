class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        helper(nums,0);
        return ans;
    }
    public void helper(int[] nums,int i){
        if(i==nums.length){
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<nums.length; j++){
                list.add(nums[j]);
            }
            if(ans.contains(list)) return;
            ans.add(list);
            return;
        }
        for(int j=i;j<nums.length; j++){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            helper(nums,i+1);
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}