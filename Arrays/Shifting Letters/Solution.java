class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] nums = s.toCharArray();
        int n = nums.length;
        int prefix=0;
        for(int i=n-1;i>=0;i--){
            prefix=(prefix+shifts[i])%26;
            nums[i] = (char)((nums[i]-'a' +prefix)%26 +'a');
        }
        return new String(nums);
    }
}
