//3. Longest Substring Without Repeating Characters
class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] freqmap= new boolean[128];

        int left=0;
        int maxseq=0;
        int n=s.length();

        for(int right=0;right<n;right++){
            while(freqmap[s.charAt(right)]){
                freqmap[s.charAt(left++)]=false;
            }
            freqmap[s.charAt(right)]=true;
            maxseq=Math.max(maxseq,right-left+1);
        }
        return maxseq;
    }
}
