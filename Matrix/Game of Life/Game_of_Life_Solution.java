class Solution {

    private static int[][] path = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};


    public void gameOfLife(int[][] board) {
        
        int n = board.length;
        int m = board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                int one = 0;

                for(int k=0;k<8;k++){
                    int nr = i + path[k][0];
                    int nc = j + path[k][1];

                    if(nr>=0 && nc>=0 && nr<n && nc<m){
                        if(board[nr][nc]==1 || board[nr][nc]==2){
                            one++;
                        }
                    }
                }

                if(board[i][j]==0 && one==3){
                    board[i][j]=3;
                }
                else if(board[i][j]==1 && (one == 2 || one == 3)){
                    board[i][j]=2;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]>=2){
                    board[i][j] = 1;
                }
                else{
                    board[i][j] = 0;
                }
            }
        }
    }
}
