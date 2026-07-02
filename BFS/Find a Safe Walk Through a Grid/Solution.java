class Solution {

    public static final int[][] path ={{-1,0},{1,0},{0,1},{0,-1}};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        
        int n = grid.size();
        int m = grid.get(0).size();

        int[][] mat = new int[n][m];
        int[][] besthealth = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j]=grid.get(i).get(j);
                besthealth[i][j]=-1;
            }
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        besthealth[0][0]=health-mat[0][0];
        queue.add(new int[]{0,0,besthealth[0][0]});

        if(besthealth[0][0]<=0){
            return false;
        }

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            int row = curr[0];
            int col = curr[1];
            int heal = curr[2];

            if(row==n-1 && col==m-1){
                return true;
            }

            for(int idx =0;idx<4;idx++){
                
                int nr = row + path[idx][0];
                int nc = col + path[idx][1];

                if(nr<0 || nc<0 || nr>=n || nc>=m){
                    continue;
                }

                int newhealth = heal-mat[nr][nc];

                if(newhealth<=0){
                    continue;
                }

                if(newhealth>besthealth[nr][nc]){
                   besthealth[nr][nc]=newhealth;
                   queue.add(new int[]{nr,nc,newhealth});
                }
            }
        }
        return false;
    }
}
