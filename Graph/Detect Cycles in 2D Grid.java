class Solution {
    int n;
    int m;
    int[][] path={{-1,0},{1,0},{0,-1},{0,1}};
    boolean[][] visited;
    public boolean containsCycle(char[][] grid) {
        n=grid.length;
        m=grid[0].length;
        visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]){
                    continue;
                }
                if(dfs(grid,i,j,-1,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] grid,int r,int c,int pr,int pc){
        visited[r][c]=true;
        for(int i=0;i<4;i++){
            int nr=r+path[i][0];
            int nc=c+path[i][1];
            if(nr>=n || nc>=m || nr<0 || nc<0){
            continue;
            }
            if(visited[nr][nc] && !(pr==nr && pc==nc) && grid[r][c]==grid[nr][nc]){
                return true;
            }
            if(!visited[nr][nc] && grid[r][c]==grid[nr][nc]){
                if(dfs(grid,nr,nc,r,c)){
                    return true;
                }
            }
        }
        return false;
    }
}
