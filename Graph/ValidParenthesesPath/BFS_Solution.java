class Solution {
    public boolean hasValidPath(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(grid[0][0]==')' || grid[n-1][m-1]=='('){
            return false;
        }
        if((m+n)%2==0){
            return false;
        }
        boolean[][][] visited=new boolean[n][m][n+m];
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{0,0,1});
        visited[0][0][1]=true;
        
        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int row=curr[0];
            int col=curr[1];
            int balance=curr[2];
            if(row==n-1 && col==m-1 && balance==0){
                return true;
            }
            if(row+1<n){
                int newbalance=balance+((grid[row+1][col]=='(')?1:-1);
                if(newbalance>=0 && newbalance<m+n && !visited[row+1][col][newbalance]){
                    visited[row+1][col][newbalance]=true;
                    queue.add(new int[]{row+1,col,newbalance});
                }
            }
            if(col+1<m){
                int newbalance=balance+((grid[row][col+1]=='(')?1:-1);
                if(newbalance>=0 && newbalance<m+n && !visited[row][col+1][newbalance]){
                    visited[row][col+1][newbalance]=true;
                    queue.add(new int[]{row,col+1,newbalance});
                }
            }
        }
        return false;
    }
}
