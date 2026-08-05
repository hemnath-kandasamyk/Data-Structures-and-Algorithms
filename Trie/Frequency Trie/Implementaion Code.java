class Trie{

    class TrieNode{
        TrieNode[] child;
        int word;

        public TrieNode(){
            this.word = 0;
            this.child = new TrieNode[26];
        }
    }

    TrieNode root;
    public Trie(){
        this.root = new TrieNode();
    }

    public void insert(String str){
        TrieNode current = this.root;

        for(char i : str.toCharArray()){
             int index = i-'a';

             if(current.child[index]==null){
                current.child[index] = new TrieNode();
             }
             current = current.child[index];
        }
        current.word++;
    }

    List<String> result = new ArrayList<>();

    public void kfrequent(int k){
        helper(this.root,k,"");
    }

    public void helper(TrieNode root,int k,String words){
        if(root.word==k){
            result.add(words);
            return;
        }
        for(int i=0;i<26;i++){
            if(root.child[i] !=null){
                helper(root.child[i],k,words+(char)(i+'a'));
            }
        }
    }
}
