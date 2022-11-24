class Solution {
    boolean[][] visited;
    HashMap<String,Integer> map;
    List<String> ans;
    int max = -1;
    public List<String> findWords(char[][] board, String[] words) {
        map = new HashMap<>();
        for(int i=0; i<words.length; i++){
            map.put(words[i],0);
            max = Math.max(words[i].length(),max);
        }
        ans = new ArrayList<>();
        
        visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                StringBuilder sb=new StringBuilder();
                dfs(board,i,j,sb);
            }
        }
        return ans;
        
    }
    
    public void dfs(char[][] board,int r,int c,StringBuilder sb){
        String str = sb.toString();
        if(map.containsKey(str)){
            ans.add(str);
            map.remove(str);
        }
        
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || visited[r][c]|| sb.length()>=max){
            return;
        }
        
        visited[r][c] = true;
        sb.append(board[r][c]);
        dfs(board,r-1,c,sb);
        dfs(board,r,c+1,sb);
        dfs(board,r+1,c,sb);
        dfs(board,r,c-1,sb);
        visited[r][c] = false;
        sb.deleteCharAt(sb.length()-1);
        return;
    }
}