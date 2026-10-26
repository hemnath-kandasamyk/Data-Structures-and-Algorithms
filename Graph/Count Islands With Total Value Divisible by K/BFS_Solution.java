class Solution {

    private static int[][] directions ={{-1,0},{1,0},{0,-1},{0,1}};
    
    public int countIslands(int[][] grid, int k) {
        
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        Queue<int[]> queue = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(grid[i][j]!=0){
                    long sum = grid[i][j];
                    grid[i][j] = 0;
                    queue.add(new int[]{i,j});

                    while(!queue.isEmpty()){
                        int[] curr = queue.poll();
                        
                        for(int index=0;index<4;index++){
                            int nr = curr[0] + directions[index][0];
                            int nc = curr[1] + directions[index][1];

                            if(!(nr<0 || nc<0 || nr>=n || nc>=m || grid[nr][nc]==0)){
                                sum = sum + grid[nr][nc];
                                grid[nr][nc] = 0;
                                queue.add(new int[]{nr,nc}); 
                            }
                        }
                    }

                    if(sum % k== 0){
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
