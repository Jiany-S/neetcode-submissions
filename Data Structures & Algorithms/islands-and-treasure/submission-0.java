class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int i = cur[0], j = cur[1];
            
            for (int[] d : dirs) {
                int ni = i + d[0], nj = j + d[1];
                if (ni < 0 || nj < 0 || ni >= m || nj >= n || grid[ni][nj] != 2147483647) continue;
                
                grid[ni][nj] = grid[i][j] + 1;
                q.offer(new int[]{ni, nj});
            }
        }
    }
}
