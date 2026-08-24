class Solution {
    public int maxScore(String s) {
        
        int n = s.length();

        int one = 0;

        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                one++;
            }
        }

        int curr0 = 0;
        int maxscores = 0;

        for(int i=0;i<n-1;i++){

            if(s.charAt(i)=='0'){
                curr0++;
            }
            else{
                one--;
            }
            maxscores = Math.max(maxscores,one+curr0);
        }

        return maxscores;
    }
}
