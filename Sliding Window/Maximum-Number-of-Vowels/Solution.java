//1456. Maximum Number of Vowels in a Substring of Given Length
class Solution {
    public int maxVowels(String s, int k) {
        char[] nums=s.toCharArray();

        int vowel=0;
        int left=0;

        int vow =0;

        for(int i=0;i<k;i++){
            if(isVowel(nums[i])){
                vow++;
            }
        }
        vowel =Math.max(vowel,vow);

        for(int i=k;i<nums.length;i++){
            if(isVowel(nums[left])){
                vow--;
            }
            if(isVowel(nums[i])){
                vow++;
            }
            vowel=Math.max(vowel,vow);
            left++;
        }

        return vowel;
    }
    public boolean isVowel(char ch){
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
}
