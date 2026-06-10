//890. Find and Replace Pattern
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> list = new ArrayList<>();

        for(String i: words){
            if(isIsomorphic(i,pattern)){
                list.add(i);
            }
        }
        return list;
    }

    public boolean isIsomorphic(String s1, String s2){

        HashMap<Character,Character> map1 = new HashMap<>();
        HashMap<Character,Character> map2 = new HashMap<>();

        if(s1.length()!=s2.length()){
            return false;
        }

        for(int i=0;i<s1.length();i++){
            char ch1=s1.charAt(i);
            char ch2=s2.charAt(i);

            if(map1.containsKey(ch1)){
                if(!(map1.get(ch1)==ch2)){
                    return false;
                }
            }

            if(map2.containsKey(ch2)){
                if(!(map2.get(ch2)==ch1)){
                    return false;
                }
            }

            map1.put(ch1,ch2);
            map2.put(ch2,ch1);

        }

        return true;
    }
}
