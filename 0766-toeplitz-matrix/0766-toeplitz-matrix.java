class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int row = 0; row<matrix.length; row++){
            if(!check(matrix,row,0)) return false;
        }
        for(int col=0; col<matrix[0].length; col++){
            if(!check(matrix,0,col)) return false;
        }
        return true;
    }
    public boolean check(int[][] matrix, int i, int j){
        int temp = matrix[i][j];
        i++;
        j++;
        for(;i<matrix.length && j<matrix[0].length; i++,j++){
            if(matrix[i][j]!=temp) return false;
        }
        return true;
    }
}