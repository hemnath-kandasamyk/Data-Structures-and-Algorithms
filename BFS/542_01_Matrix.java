//542. 01 Matrix
class Solution {
    public int[][] updateMatrix(int[][] mat) {
       int n=mat.length;
       int m=mat[0].length;
       int[][] path={{-1,0},{1,0},{0,1},{0,-1}}; 
        
       Queue<int[]> queue=new LinkedList<>();
        
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(mat[i][j]==0){
                   queue.add(new int[]{i,j});
               }
               else{
                   mat[i][j]=-1;
               }
           }
       }
       while(!queue.isEmpty()){
           int[] curr=queue.poll();
           int row=curr[0];
           int col=curr[1];
           for(int i=0;i<4;i++){
               int nr=row+path[i][0];
               int nc=col+path[i][1];
               if(nr>=0 && nc>=0 && nr<n && nc<m && mat[nr][nc]==-1){
                   mat[nr][nc]=mat[row][col]+1;
                   queue.add(new int[]{nr,nc});
               }
           }
       } 
        return mat;
    }
}
