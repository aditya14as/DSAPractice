class Solution {
    public int[] searchRange(int[] arr, int target) {
        int idx = search(arr,0,arr.length-1,target);
        int[] ans = {-1 ,-1};
        if(idx == -1 || arr.length == 1){
            ans[0] = idx;
            ans[1] = idx;
            return ans;
        }
        int temp = idx;
        while(temp>=0 && arr[temp] == target){
            temp--;
        }
        // int[] ans = {-1 ,-1};
        ans[0] = temp+1;
        temp = idx;
        while(temp<arr.length && arr[temp] == target){
            temp++;
        }
//        int[] ans = new int[2];
        ans[1] = temp-1;
        return ans;
    }
    int search(int[] arr, int s, int e, int target){

        while(s<=e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }
}