class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long[] pre = new long[chalk.length];
        pre[0]=chalk[0];
        for(int i=1; i<chalk.length; i++){
            pre[i]= pre[i-1]+chalk[i];
            
        }
        long sum = pre[pre.length-1];
        System.out.println(Arrays.toString(pre));
        
        int idx = binarySearch(pre,0,pre.length-1,(int)(k%sum));
        return idx==pre.length?0:idx;
    }
    public int binarySearch(long[] arr, int start , int end,int target){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]<=target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return start;
    }
}