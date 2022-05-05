class Solution {
    public int[][] merge(int[][] arr) {
        if(arr.length<2){
            return arr;
        }
        //Sort 2D array in terms of increasing order of their start
        Arrays.sort(arr,(a,b) -> a[0]-b[0]);
        
        List<int[]> ans = new ArrayList<int[]>();
        
        int n = arr.length;
        int[] prev = arr[0];
        ans.add(prev);
        
        for(int i=1; i<arr.length; i++){
            int[] curr = arr[i];
            
            //Check if overlapping
            if(prev[1]>=curr[0]){
                
                //check if curr array is not completely inside the previous array
                if(curr[1]>prev[1]){
                    prev[1] = curr[1];
                }
                
            }else{
                prev = curr;
                ans.add(curr);
            }
        }
        
        //size of ans Arraylist
        int s = ans.size();
        
        //Convert ans arraylist into array and return it
        return ans.toArray(new int[s][]);
        
        
    }
}