class Solution {
    public int[] sortedSquares(int[] nums) {
      int n=nums.length;
      int maximum=0;
      int[] result=new int[n];
      for(int i=0;i<n;i++){
        result[i]=(nums[i]<0)?-nums[i]:nums[i];
        if(maximum<result[i]){
            maximum=result[i];
        }
      }
      int[] freq =new int[maximum+1];
      for(int i:result){
        freq[i]++;
      }
      int idx=0;
      for(int i=0;i<=maximum;i++){
        while(freq[i]!=0){
            result[idx++]=i*i;
            freq[i]--;
        }
      }
      return result;
    }
}
