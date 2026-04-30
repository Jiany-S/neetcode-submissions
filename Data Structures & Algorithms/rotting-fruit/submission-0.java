class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j]==2)
                    queue.offer(new int[]{i,j,0});
            }
        }
        int max = 0;
        int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            max = Math.max(temp[2],max);
            int i = temp[0], j = temp[1];
            for(int[] d : directions){
                int ni=i+d[0],nj=j+d[1];
                if(ni<0||nj<0||ni>=grid.length||nj>=grid[0].length||grid[ni][nj]!=1)   continue;
                grid[ni][nj]=2;
                queue.offer(new int[]{ni,nj,temp[2]+1});
            }
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j]==1)
                    return -1;
            }
        }
        return max;
    }
}
