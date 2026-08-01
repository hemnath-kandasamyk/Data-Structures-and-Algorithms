class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,List<String>> map = new HashMap<>();

        for (String i : strs){
            char[] nums = i.toCharArray();
            Arrays.sort(nums);

            String key = new String(nums);

            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(i);
        }

        List<List<String>> list = new ArrayList<>();

        for(String key : map.keySet()){
            list.add(map.get(key));
        }
        return list;
    }
}
