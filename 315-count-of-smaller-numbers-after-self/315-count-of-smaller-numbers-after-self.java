class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> sorted = new ArrayList<>();
        for(int i:nums){
            sorted.add(i);
        }
        Collections.sort(sorted);
        
        for(int i=0; i<nums.length; i++){
            int idx= binarySearch(sorted,nums[i],0,sorted.size()-1);
            ans.add(idx);
            sorted.remove(idx);
        }
        return ans;
    }
    public int binarySearch(List<Integer> arr,int target,int i, int j){
       int ans=0;
        while(i<=j){
            int mid = i+(j-i)/2;
            
            if(arr.get(mid)<target){
                i=mid+1;
            }else if(arr.get(mid)>target){
                j=mid-1;
            }else{
                ans = mid;
                j=mid-1;
            }
        }
        return ans;
    }
}