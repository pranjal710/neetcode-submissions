class WordDictionary {

    public static class TrieNode{
        private TrieNode[] children;
        private boolean isEnd;

        public TrieNode(boolean isEnd) {
            this.isEnd = isEnd;
            this.children = new TrieNode[26];
        }

        public boolean isEnd() {
            return this.isEnd;
        }

        public int getIndex(char ch) {
            return ch - 'a';
        }

        public TrieNode getChildNode(char ch) {
            return this.children[this.getIndex(ch)];
        }

        public List<TrieNode> getValidChildNode() {
            List<TrieNode> valids = new ArrayList<>();
            for(TrieNode t : this.children) {
                if(t != null) {
                    valids.add(t);
                }
            }
            return valids;
        }

        public TrieNode addNode(char ch, boolean isEnd) {
            if(this.getChildNode(ch) == null) {
                this.children[getIndex(ch)] = new TrieNode(isEnd);
            }
            TrieNode node = this.getChildNode(ch);
            if(isEnd) {
                node.isEnd = true;
            }
            return node;
        }
    }

    private TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode(false);
    }

    public void addWord(String word) {
        char[] chars = word.toCharArray();
        TrieNode curr = this.root;
        for(int i = 0 ; i < chars.length; i++) {
            curr = curr.addNode(chars[i], i == (chars.length - 1));
        }
    }

    private boolean searchRecur(char[] chars, int index, TrieNode root) {
        if(root == null) {
            return false;
        } else if(index == chars.length) {
            return root.isEnd();
        } else {
            if(chars[index] != '.') {
                return searchRecur(chars, index+1, root.getChildNode(chars[index]));
            } else {
                boolean exists = false;
                for(TrieNode t : root.getValidChildNode()) {
                    exists = exists || searchRecur(chars, index+1, t);
                }
                return exists;
            }
        }
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        return searchRecur(chars, 0, this.root);
    }
}
