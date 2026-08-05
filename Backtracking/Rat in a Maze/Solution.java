//Rat in a Maze
class Solution {
    int n;
    ArrayList<String> result = new ArrayList<>();
    private static final int[][] moves = {{1,0},{0,-1},{0,1},{-1,0}};
    private static final char[] dir = {'D','L','R','U'};
    
    public ArrayList<String> ratInMaze(int[][] maze) {
        this.n = maze.length;
        backtrack(new StringBuilder(),maze,0,0);
        return result;
    }
    
    public void backtrack(StringBuilder path,int[][] maze,int row,int col){
        if(row == n-1 && col == n-1 && maze[row][col]==1){
            result.add(path.toString());
            return;
        }
        
        if(row>=n || col>=n || row<0 || col<0 || maze[row][col]==0){
            return;
        }
        
        maze[row][col] = 0;
        
        for(int i=0;i<4;i++){
            
            int nr = row + moves[i][0];
            int nc = col + moves[i][1];
        
            if(nr>=0 && nc>=0 && nr<n && nc<n && maze[nr][nc]==1){
                path.append(dir[i]);
                backtrack(path,maze,nr,nc);
                path.deleteCharAt(path.length()-1);
            }
        }
        
        maze[row][col]=1;
    }
}
