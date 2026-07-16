1class Solution {
2    public boolean hasSameDigits(String s) {
3        char[]  nums = s.toCharArray();
4        int steps = nums.length;
5        while(steps>2){
6            for(int i=0;i<steps-1;i++){
7                nums[i]=(char)(((int)(nums[i]-'0')+(int)(nums[i+1]-'0'))%10 +'0');
8            }
9            steps--;
10        }
11        return nums[0]==nums[1];
12    }
13}