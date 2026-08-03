class Trie {

    class TrieNode{
        TrieNode[] child = new TrieNode[26];
        boolean flag = false;
    }

    public Trie() {
        root = new TrieNode();
    }

    TrieNode root;
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char i : word.toCharArray()){
            int index = i-'a';
            if(curr.child[index]==null){
                curr.child[index] = new TrieNode();
            }
            curr=curr.child[index];
        }
        curr.flag = true;
    }
    
    public boolean search(String word) {
        
        TrieNode curr = root;

        for (char i : word.toCharArray()){
            int index =i-'a';
            if(curr.child[index]==null){
                return false;
            }
            curr = curr.child[index];
        }
        return curr.flag;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for (char i : prefix.toCharArray()){
            int index = i-'a';
            if(curr.child[index]==null){
                return false;
            }
            curr = curr.child[index];
        }
        return true;
    }
}
