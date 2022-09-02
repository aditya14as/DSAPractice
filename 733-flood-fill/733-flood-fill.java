class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        int startColor = image[sr][sc];
        helper(image,sr,sc,color,startColor,visited);
        return image;
    }
    public void helper(int[][] image,int i, int j,int color, int startColor, boolean[][] visited){
        if(i<0 || j<0 || i>=image.length || j>=image[0].length ||image[i][j]!=startColor || visited[i][j]==true){
            return;
        }
        visited[i][j]=true;
        if(image[i][j]==startColor){
            image[i][j]=color;
        }
        helper(image,i,j+1,color,startColor,visited);
        helper(image,i+1,j,color,startColor,visited);
        helper(image,i,j-1,color,startColor,visited);
        helper(image,i-1,j,color,startColor,visited);
        
    }
}