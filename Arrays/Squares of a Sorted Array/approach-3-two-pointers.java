//977. Squares of a Sorted Array
class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int n=nums.length;

        for(int i=0;i<n;i++){
            nums[i]*=nums[i];
        }
        
        int left=0,right=n-1;
        int[] result=new int[n];
        int idx=n-1;

        while(left<=right){
            if(nums[left]>nums[right]){
                result[idx--]=nums[left++];
            }
            else{
                result[idx--]=nums[right--];
            }
        }
        return result;
    }
}
