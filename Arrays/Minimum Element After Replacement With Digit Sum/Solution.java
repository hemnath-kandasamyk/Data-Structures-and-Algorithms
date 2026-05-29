//3300. Minimum Element After Replacement With Digit Sum
class Solution {
    public int minElement(int[] nums) {
        
        int n=nums.length;
        int mini=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            int temp=nums[i];
            int numb=0;

            while(temp!=0){
                numb+=(temp%10);
                temp/=10;
            }

            mini=Math.min(mini,numb);
        } 
        return mini;
    }
}
