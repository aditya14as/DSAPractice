class NumArray {
    int[] arr;
    int total;
    public NumArray(int[] nums) {
        int n = nums.length;
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=nums[i];
            total += nums[i];
        }
    }
    
    public void update(int index, int val) {
        total= total+val-arr[index];
        arr[index] = val;
        
    }
    
    public int sumRange(int left, int right) {
        int sum = total;
        for(int i=0; i<left; i++){
            sum-=arr[i];
        }
        for(int i=right+1; i<arr.length; i++){
            sum-=arr[i];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */