class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        for(int i=1;i<n;i++){
           if(nums[i]<nums[i-1]){
            for(int j=0;j<n-1;j++){
                if(nums[(j+i)%n]>nums[(j+i+1)%n]){
                    return false;
                }
            }
            break;
           }
        }
        return true;
    }
}
