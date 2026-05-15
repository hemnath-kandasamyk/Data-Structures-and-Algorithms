class Solution {
    public int orangesRotting(int[][] grid) {
       int n=grid.length;
       int m=grid[0].length;
       int[][] path={{-1,0},{1,0},{0,-1},{0,1}};
       int one=0;
       int steps=0;
       
       Queue<int[]> queue=new LinkedList<>();
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(grid[i][j]==2){
                   queue.add(new int[]{i,j});
               }
               else if(grid[i][j]==1){
                   one++;
               }
           }
       }
       if(one==0){
           return 0;
       }
       while(!queue.isEmpty()){
           int size=queue.size();
           boolean rotten=false;
           for(int idx=0;idx<size;idx++){
              int[] curr=queue.poll(); 
              int row=curr[0];
              int col=curr[1];
              for(int i=0;i<4;i++){
                  int nr=row+path[i][0];
                  int nc=col+path[i][1];
                  if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==1){
                      grid[nr][nc]=2;
                      queue.add(new int[]{nr,nc});
                      rotten=true;
                      one--;
                  }
              } 
           }
           if(rotten){
               steps++;
           }
       }
        return (one<=0)?steps:-1;
    }
}
