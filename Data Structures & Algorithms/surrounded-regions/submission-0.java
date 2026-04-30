class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited= new boolean[n][m];
        for(int i = 0; i<n;i++){
            dfs(board,visited,i,0);
            dfs(board,visited,i,m-1);
        }
        for(int i = 0; i<m;i++){
            dfs(board,visited,0,i);
            dfs(board,visited,n-1,i);
        }
        for(int i = 1; i<n-1;i++){
            for(int j = 1; j<m-1;j++){
                if(!visited[i][j])
                    board[i][j]='X';
            }
        }
    }
    void dfs(char[][] board, boolean[][] visited,int i , int j){
        if(i<0||j<0||i>=board.length||j>=board[0].length||visited[i][j]||board[i][j]=='X')
            return;
        visited[i][j]=true;
        dfs(board,visited,i,j+1);
        dfs(board,visited,i,j-1);
        dfs(board,visited,i+1,j);
        dfs(board,visited,i-1,j);
    } 
}
