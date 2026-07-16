class Solution {
    public boolean hasSameDigits(String s) {
        char[]  nums = s.toCharArray();
        int steps = nums.length;
        while(steps>2){
            for(int i=0;i<steps-1;i++){
                nums[i]=(char)(((int)(nums[i]-'0')+(int)(nums[i+1]-'0'))%10 +'0');
            }
            steps--;
        }
        return nums[0]==nums[1];
    }
}