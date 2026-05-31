class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
      Arrays.sort(asteroids);
      long currentmass=mass;
      for(int i=0;i<asteroids.length;i++){
        if(currentmass<asteroids[i]){
            return false;
        }
        currentmass+=asteroids[i];
      }  
      return true;
    }
}
