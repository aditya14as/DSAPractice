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
    public int lessEqualHelper(int[][] matrix,int mid){
        int i=matrix.length-1;
        int j=0;
        int c=0;
        while(i>=0 && j<matrix.length){
            if(mid<matrix[i][j]){
                i--;
            }else{
                c= c+i+1;
                j++;
            }
        }
        return c;
    }
}