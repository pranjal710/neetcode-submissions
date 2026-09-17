class PrefixTree {
    public static class TrieNode {
        private TrieNode[] children;
        private boolean isEnd;

        public TrieNode(boolean isEnd) {
            this.children = new TrieNode[26];
            this.isEnd = isEnd;
        }

        public boolean isEnd(){
            return this.isEnd;
        }

        public void setIsEnd(boolean isEnd){
            this.isEnd = isEnd;
        }

        public int getIndex(char ch) {
            return ch - 'a';
        }

        public TrieNode getChildNode(char ch) {
            return this.children[getIndex(ch)];
        }

        public TrieNode createChildNode(char ch, boolean isEnd)  {
            if(this.children[getIndex(ch)] == null) {
                this.children[getIndex(ch)] = new TrieNode(isEnd);
            }
            TrieNode child = this.getChildNode(ch);
            if(isEnd) {
                child.setIsEnd(true);
            }
            return child;
        }

    }

    private final TrieNode root;

    public PrefixTree() {
         this.root = new TrieNode(false);
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode curr = this.root;
        for(int i = 0 ; i < chars.length ; i++) {
            curr = curr.createChildNode(chars[i], i == (chars.length - 1));
        }
    }

    private TrieNode getLastNode(String word) {
        
        char[] chars = word.toCharArray();
        TrieNode curr = this.root;
        for(int i = 0 ; i < chars.length ; i++) {
            curr = curr.getChildNode(chars[i]);
            if(curr == null) {
                return null;
            }
        }
        return curr;
    }

    public boolean search(String word) {
        if("".equals(word)) return true;
        TrieNode curr = getLastNode(word);
        return curr != null && curr.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = getLastNode(prefix);
        return curr != null;
    }
}
