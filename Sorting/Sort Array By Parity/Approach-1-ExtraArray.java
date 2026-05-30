class Solution {
    public int[] sortArrayByParity(int[] nums) {
     
        int n=nums.length;
        
        int[] result=new int[n];
        
        int start =0,end=n-1;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                result[start++]=nums[i];
            }
            else{
                result[end--]=nums[i];
            }
        }
        
        return result;
    }
}
