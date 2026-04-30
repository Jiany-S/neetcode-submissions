class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max =0;
            for(int i = 0; i<grid.length;i++){
                for(int j = 0; j<grid[0].length;j++){
                    if(grid[i][j]==1){
                        int[] tot = new int[1];
                        help(grid,i,j,tot);
                        max = Math.max(max,tot[0]);
                    }
                }
            }
        return max;
    }
    void help(int[][]grid,int i, int j,int[] tot){
        if(i<0||j<0||i==grid.length||j==grid[0].length||grid[i][j]==0)
            return;
        grid[i][j]=0;
        tot[0]++;
        help(grid,i,j+1,tot);
        help(grid,i+1,j,tot);
        help(grid,i,j-1,tot);
        help(grid,i-1,j,tot);
    }
}