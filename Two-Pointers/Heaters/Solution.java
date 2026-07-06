//475. Heaters
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int n = houses.length;
        int m = heaters.length;

        int[] res = new int[n];

        int j = 0;

        for(int i=0;i<n;i++){
            
            while(j+1<m && heaters[j+1]<=houses[i]){
                j++;
            }
            res[i]=Math.abs(houses[i]-heaters[j]);
        }

        j=m-1;
        int maxi =0;
        for(int i=n-1;i>=0;i--){
            while(j-1>=0 && heaters[j-1]>=houses[i]){
                j--;
            }

            res[i]=Math.min(res[i],Math.abs(houses[i]-heaters[j]));

            maxi = Math.max(maxi,res[i]);
        }
        return maxi;
    }
}
