class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n= matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        while(low<=high){
            int mid = low+(high-low)/2;
            int c = lessEqualHelper(matrix, mid);
            if(c<k){
                low=mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
    public int lessEqualHelper(int[][] matrix,int target){
        //Applying binary search on each row for finding how many number smaller than target 
        //after for loop ends we return all the numbers smaller than target
        int ans = 0;
        for(int i=0; i<matrix.length; i++){
            int low = 0;
            int high = matrix[0].length-1;
            while(low<=high){
               int mid = low+(high-low)/2;
                if(matrix[i][mid]<=target){
                    low=mid+1;
                }else{
                    high = mid-1;
                }
            }
            ans = ans +low;
        }
        return ans;
    }
}