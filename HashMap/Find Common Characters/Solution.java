//1002. Find Common Characters
class Solution {
    public List<String> commonChars(String[] words) {
       List<String> list=new ArrayList<>();
       int[] freq=new int[26];
       for(int i=0;i<words[0].length();i++){
           char ch=words[0].charAt(i);
           freq[ch-'a']++;
         }
        for(int i=1;i<words.length;i++){
            int[] currfreq=new int[26];
            for(char j:words[i].toCharArray()){
                currfreq[j-'a']++;
            }
            for(int k=0;k<26;k++){
                freq[k]=Math.min(freq[k],currfreq[k]);
            }
        }
        for(int i=0;i<26;i++){
            while(freq[i]!=0){
                list.add((char)(i+'a')+"");
                freq[i]--;
            }
        }
       return  list; 
    }
}
