//2126. Destroying Asteroids
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int[] freq=new int[100001];
        int max=0;
        for(int i:asteroids){
           freq[i]++;
           max=Math.max(max,i);
        }

        long curr=mass;
        for(int i=0;i<100001;i++){
            if(freq[i]!=0){
                if(curr<i){
                    return false;
                }
                curr+=freq[i]*i;
            }
            if(curr>=max){
                return true;
            }
        }
        return true;
    }
}
