//994. Rotting Oranges
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        Queue<int[]> queue=new LinkedList<>();
        int[][] path={{-1,0},{1,0},{0,-1},{0,1}};

        int one=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
              if(grid[i][j]==2){
                queue.add(new int[]{i,j});
              }
              if(grid[i][j]==1){
                one++;
              }  
            }
        }
        if(one==0){
            return 0;
        }

        int count=0;
        
        while(!queue.isEmpty()){
            int size=queue.size();
            boolean rotted=false;
            for(int idx=0;idx<size;idx++){
                int[] curr=queue.poll();
                int row=curr[0];
                int col=curr[1];
                for(int j=0;j<4;j++){
                    int nr=row+path[j][0];
                    int nc=col+path[j][1];
                    if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        one--;
                        queue.add(new int[]{nr,nc});
                        rotted=true;
                    }
                }
            }
            if(rotted){
                count++;
            }
        }
        return one==0?count:-1;
    }
}
