class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int low =1;
        int high = piles[0];

        for (int pile : piles){
            high = Math.max(pile,high);
        }

        while(low<=high){

            int mid = low + (high-low)/2;
            long eat = 0;

            for(int pile : piles){
                eat += (pile/mid) + (pile%mid == 0?0:1); 
            }

            if(eat<=h){
                high=mid-1;
            }
            else{
                low=mid+1;
            }

        }
        return low;
    }
}
