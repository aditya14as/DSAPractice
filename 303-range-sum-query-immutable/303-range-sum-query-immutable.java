class NumArray {
    int[] arr;
    int sum=0;
    public NumArray(int[] nums) {
        arr = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            arr[i]=nums[i];
            sum=sum+nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        int temp = sum;
        for(int i=0; i<left; i++){
            temp = temp- arr[i];
        }
        for(int j=right+1; j<arr.length; j++){
            temp = temp - arr[j];
        }
        return temp;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */