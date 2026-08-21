class Solution {

    int n,m;
    List<String> result = new ArrayList<>();

    private static final int[][] path = {{-1,0},{1,0},{0,-1},{0,1}};

    public List<String> findWords(char[][] board, String[] words) {
        this.n = board.length;
        this.m = board[0].length;

        Trie trie = new Trie();
        for(int i=0;i<words.length;i++){
            trie.insert(words[i]);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dfs(board,i,j,trie.root);
            }
        }

        return result;
    }

    public void dfs(char[][] board,int row,int col,Trie.TrieNode node){

        if(row<0 || col<0 || row>=n || col>=m || board[row][col]=='#'){
            return;
        }
        char ch = board[row][col];
        int index = ch-'a';

        if(node.child[index]==null){
            return;
        }

        node = node.child[index];
        if(node.isword != null){
            result.add(node.isword);
            node.isword = null;
        }
        board[row][col] = '#';
        for(int i=0;i<4;i++){
            int nr = row + path[i][0];
            int nc = col + path[i][1];
            dfs(board,nr,nc,node);
        }
        board[row][col] = ch;
    }
}

class Trie{

    class TrieNode{
        TrieNode[] child;
        String isword;

        public TrieNode(){
            this.child = new TrieNode[26];
            this.isword = null;
        }
    }

    TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }

    public void insert(String word){
        TrieNode curr = this.root;

        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';

            if(curr.child[index]==null){
                curr.child[index] = new TrieNode();
            }

            curr = curr.child[index];
        }
        curr.isword = word;
    }
}
