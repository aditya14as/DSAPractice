class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        for(int g=0; g<n; g++){
            List<Integer> temp  = new ArrayList<>();
            for(int i=0 ,j=g; i<mat.length && j<mat[0].length; i++,j++){
                temp.add(mat[i][j]);
            }
            Collections.sort(temp);
            for(int i=0 ,j=g; i<mat.length && j<mat[0].length; i++,j++){
                ans[i][j]=temp.get(i);
            }
        }
        for(int g=1; g<m; g++){
            List<Integer> temp  = new ArrayList<>();
            for(int i=g ,j=0; i<mat.length && j<mat[0].length; i++,j++){
                temp.add(mat[i][j]);
            }
            Collections.sort(temp);
            for(int i=g ,j=0; i<mat.length && j<mat[0].length; i++,j++){
                ans[i][j]=temp.get(j);
            }
        }
        return ans;
    }
}