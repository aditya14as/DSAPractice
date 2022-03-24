class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i= 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                if(visited[i][j]==false && grid[i][j]=='1'){
                    drawTreeForComponent(grid,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }
    public void drawTreeForComponent(char[][] grid,int i ,int j, boolean[][] visited){
        if(i<0 || j<0 || i>=grid.length || j>= grid[i].length || grid[i][j]=='0' || visited[i][j]==true){
            return;
        }
        visited[i][j] =true;
        drawTreeForComponent(grid,i-1,j,visited);
        drawTreeForComponent(grid,i,j+1,visited);
        drawTreeForComponent(grid,i,j-1,visited);
        drawTreeForComponent(grid,i+1,j,visited);
        
    }
}