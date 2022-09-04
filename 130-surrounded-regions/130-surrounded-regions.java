class Solution {
    public void solve(char[][] board) {
        
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || j==0 || i==m-1 || j==n-1){
                    if(board[i][j]=='O'){
                        dfs(visited,i,j,board);
                    }
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j]==false){
                    if(board[i][j]=='O'){
                        board[i][j]='X';
                    }
                }
            }
        }
    }
    public void dfs(boolean[][] visited,int i, int j,char[][] board){
        if(i<0 || j<0 || i>=visited.length || j>=visited[0].length || board[i][j]=='X' || visited[i][j]==true){
            return;
        }
        visited[i][j]=true;
        dfs(visited,i,j+1,board);
        dfs(visited,i+1,j,board);
        dfs(visited,i,j-1,board);
        dfs(visited,i-1,j,board);
    }
}