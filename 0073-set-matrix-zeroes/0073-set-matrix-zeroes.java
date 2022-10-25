class Solution {
    public void setZeroes(int[][] matrix) {
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    int[] temp = {i,j};
                    list.add(temp);
                }
            }
        }
        for(int i=0; i<list.size(); i++){
            reset(matrix,list.get(i)[0],list.get(i)[1]);
        }
        
    }
    public void reset(int[][] matrix,int i, int j){
        for(int r=0; r<matrix.length; r++){
            matrix[r][j] = 0;
        }
        for(int c=0; c<matrix[0].length; c++){
            matrix[i][c] = 0;
        }
    }
}