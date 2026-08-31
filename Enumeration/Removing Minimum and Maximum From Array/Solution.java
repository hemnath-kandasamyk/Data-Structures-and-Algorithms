// 2091. Removing Minimum and Maximum From Array
class Solution {
    public int minimumDeletions(int[] nums) {
        
        int n = nums.length;

        if(n<=2){
            return n;
        }

        int minidx = 0;
        int maxidx = 0;

        for(int i=1;i<n;i++){
            if(nums[minidx]>nums[i]){
                minidx = i;
            }

            if(nums[maxidx]<nums[i]){
                maxidx = i;
            }
        }

        int poss1 = minidx+1 + n-maxidx;
        int poss2 = maxidx+1 + n-minidx;
        int poss3 = Math.max(minidx,maxidx)+1;
        int poss4 = n-Math.min(minidx,maxidx);
        int temp1 = Math.min(poss3,poss4);
        int temp2 = Math.min(poss1,poss2);
        return Math.min(temp1,temp2);
    }
}
