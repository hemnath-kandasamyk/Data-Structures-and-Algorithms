//149. Max Points on a Line
class Solution {
    public int maxPoints(int[][] points) {

        int n = points.length;

        if(n<=2){
            return n;
        }

        int answer = 0;

        for(int i=0;i<n;i++){

            HashMap<Double,Integer> map = new HashMap<>();
            int maxpoints = 0;

            for(int j=i+1;j<n;j++){

                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                Double slope;

                if(dx==0){
                    slope =  Double.POSITIVE_INFINITY;
                }
                else if(dy==0){
                    slope = 0.0;
                }
                else{
                    slope = (double)dy/dx;
                }
                

                int count = map.getOrDefault(slope,0)+1;
                map.put(slope,count);
                maxpoints = Math.max(maxpoints,count);
            }
            answer = Math.max(answer,maxpoints+1);
        }
        
        return answer;
    }
}
