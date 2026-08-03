class WordDictionary {

    class TrieNode{
        TrieNode[] child;
        boolean isWord;

        public TrieNode(){
            this.child = new TrieNode[26];
            this.isWord = false;
        }
    }
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode current = root;

        for(char i : word.toCharArray()){
            int index = i-'a';

            if(current.child[index]==null){
                current.child[index] = new TrieNode();
            }
            current = current.child[index];
        }
        current.isWord = true;
    }
    
    public boolean search(String word) {
        return helper(word,this.root,0);
    }

    public boolean helper(String word , TrieNode root,int index){

        TrieNode curr = root;

        for(int i=index;i<word.length();i++){
            
            char ch = word.charAt(i);

            if(ch=='.'){
                boolean valid = false;
                for(int idx =0;idx<26;idx++){
                    if(curr.child[idx]!=null){
                        valid = valid || helper(word,curr.child[idx],i+1);
                    }
                    if(valid){
                        return true;
                    }
                }
                return valid;
            }
            else{
                if(curr.child[ch-'a']==null){
                    return false;
                }
                curr = curr.child[ch-'a'];
            }
        }
        return curr.isWord;
    }
}
