class Solution {
    public int singleNumber(int[] nums) {
        int s = 0;
        //XOR any no with itself will give 0
        // XOR all no then every duplicate no will yeild zero except single one
        for(int i = 0; i<nums.length; i++){
            s = s ^ nums[i];
        }
        return s;
    }
}