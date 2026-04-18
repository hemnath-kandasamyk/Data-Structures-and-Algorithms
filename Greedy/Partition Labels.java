class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result=new ArrayList<>();
        int n=s.length();
        int[] freq=new int[26];
        for(int i=0;i<n;i++){
            freq[s.charAt(i)-'a']=i;
        }
        int start=0;
        int end=0;
        for(int i=0;i<n;i++){
            end=Math.max(end,freq[s.charAt(i)-'a']);
            if(i==end){
              result.add(end-start+1);
              start=i+1;
            }
        }
        return result;
    }
}
