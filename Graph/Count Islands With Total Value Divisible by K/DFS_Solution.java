class Solution {

    int n;
    int m;
    long sum =0;
    public int countIslands(int[][] grid, int k) {
        
        this.n = grid.length;
        this.m = grid[0].length;

        int count =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0){
                   dfs(grid,i,j);
                   if(sum%k==0){
                    count++;
                   }
                   sum = 0;
                }
            }
        }

        return count;
    }

    public void dfs(int[][] grid,int row,int col){
        if(row<0 || col<0 || row>=n || col>=m || grid[row][col]==0){
            return;
        }
        sum = sum + grid[row][col];
        
        grid[row][col] =0;
        dfs(grid,row-1,col);
        dfs(grid,row+1,col);
        dfs(grid,row,col-1);
        dfs(grid,row,col+1);

        return;
    }
}
