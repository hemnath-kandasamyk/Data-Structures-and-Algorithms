//1493. Longest Subarray of 1's After Deleting One Element
class Solution {
    public int longestSubarray(int[] nums) {
        int left=0;
        int sub=0;
        int zeroidx=-1;
        int n=nums.length;

        for(int right=0;right<n;right++){
           while(nums[right]==0 && zeroidx!=-1){
             if(nums[left]==0){
                zeroidx=-1;
             }
             left++;
           }
           if(nums[right]==0){
            zeroidx=right;
           }
           sub=Math.max(sub,right-left);
        }
        return sub;
    }
}
