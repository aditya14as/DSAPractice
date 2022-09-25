class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        if(x<=arr[0]){
            for(int i=0; i<k; i++) list.add(arr[i]);
        }
        else if(x>=arr[n-1]){
            for(int i=k; i>0; i--){
                list.add(arr[n-i]);
            }
        }else{
            int idx = binarySearch(arr,0,arr.length-1,x);
            int left = idx-1;
            int right = idx;
            int count = 0;
            while(count<k){
                if(left<0){
                    list.add(arr[right]);
                    right++;
                }else if(right>=n){
                    list.add(0,arr[left]);
                    left--;
                }else{
                    int ld = Math.abs(arr[left]-x);
                    int rd = Math.abs(arr[right]-x);
                    if(ld<=rd){
                        list.add(0,arr[left]);
                        left--;
                    }else{
                        list.add(arr[right]);
                        right++;
                    }
                }
                count++;
            }
        }
        // Collections.sort(list);
        return list;
    }
    public int binarySearch(int[] arr, int start , int end,int target){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return start;
    }
}