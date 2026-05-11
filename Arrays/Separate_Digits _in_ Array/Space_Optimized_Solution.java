class Solution {
    public int[] separateDigits(int[] nums) {
        int n=0;
        for(int i:nums){
            int temp=i;
            if(temp==0){
                n++;
            }
            while(temp!=0){
                n++;
                temp/=10;
            }
        }
        int[] result=new int[n];
        for(int i=nums.length-1;i>=0;i--){
            int temp=nums[i];
            if(temp==0){
                result[--n]=temp;
            }
            while(temp!=0){
                result[--n]=temp%10;
                temp/=10;
            }
        }
        return result; 
    }
}
