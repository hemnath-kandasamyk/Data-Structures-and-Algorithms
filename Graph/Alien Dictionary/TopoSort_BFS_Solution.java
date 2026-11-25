// Alien Dictionary
class Solution {
    public String findOrder(String[] words) {
        
        List<Set<Integer>> graph = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        
        boolean[] present = new boolean[26];
        int[] indegree = new int[26];
        
        int count = 0;
        
        for(int i=0;i<26;i++){
            graph.add(new HashSet<>());
        }
        
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                int ch = words[i].charAt(j) -'a';
                
                if(!present[ch]){
                    present[ch] =true;
                    count++;
                }
            }
        }
        
        for(int i=0;i<words.length-1;i++){
            
            String str1 = words[i];
            String str2 = words[i+1];
            
            int ptr1 = 0;
            int ptr2 = 0;
            
            while(ptr1<str1.length() && ptr2<str2.length()){
                
                if(str1.charAt(ptr1) != str2.charAt(ptr2)){
                    
                    int char1 = (int) (str1.charAt(ptr1)-'a');
                    int char2 = (int) (str2.charAt(ptr2)-'a');
                    
                    graph.get(char1).add(char2);
                    break;
                }
                
                ptr1++;
                ptr2++;
            }
        }
        
        for(int i=0;i<26;i++){
            for(int node : graph.get(i)){
                indegree[node]++;
            }
        }
        
        for(int i=0;i<26;i++){
            if(indegree[i] == 0 && present[i]){
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()){
            
            int node = queue.poll();
            ans.append((char)(node+'a'));
            
            for (int neighbour : graph.get(node)){
                
                indegree[neighbour]--;
                
                if(indegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }
        
        return (ans.length()==count)?ans.toString():"";
    }
}
