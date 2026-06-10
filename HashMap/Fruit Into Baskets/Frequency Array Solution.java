//904. Fruit Into Baskets
class Solution {
    public int totalFruit(int[] fruits) {

        int n = fruits.length;
        int[] freq= new int[n];
        int freqsize=0;

        int maxlen =0;
        int left =0;

        for(int right=0;right<n;right++){
            if(freq[fruits[right]]==0){
                freqsize++;
            }
            freq[fruits[right]]++;

            while(freqsize>2){
                freq[fruits[left]]--;

                if(freq[fruits[left]]==0){
                    freqsize--;
                }
                left++;
            }

            maxlen=Math.max(maxlen,right-left+1);
        }     
        return maxlen;
    }
}
