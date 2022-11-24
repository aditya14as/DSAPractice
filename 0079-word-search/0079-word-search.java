class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(dfs(board,i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,int r,int c,String word,int i){
        if(i==word.length()) return true;
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || visited[r][c] || board[r][c]!=word.charAt(i)){
            return false;
        }
        visited[r][c] = true;
        boolean u = dfs(board,r-1,c,word,i+1);
        boolean ri = dfs(board,r,c+1,word,i+1);
        boolean d = dfs(board,r+1,c,word,i+1);
        boolean l = dfs(board,r,c-1,word,i+1);
        visited[r][c] = false;
        return (u || ri || d || l);
    }
}