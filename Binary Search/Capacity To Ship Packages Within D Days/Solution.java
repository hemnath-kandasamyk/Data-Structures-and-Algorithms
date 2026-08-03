class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        long low = 0;
        long high = 0;

        for(int weight : weights){
            high+=weight;
            low = Math.max(low,weight);
        }

        while(low<high){
            
            long mid = low + (high-low)/2;

            long work = 0;
            int workdays =1;

            for(int weight : weights){
                if(work+weight>mid){
                    work =weight;
                    workdays++;
                }
                else{
                    work+=weight;
                }
            }

            if(workdays<=days){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }

        return (int)low;
    }
}
