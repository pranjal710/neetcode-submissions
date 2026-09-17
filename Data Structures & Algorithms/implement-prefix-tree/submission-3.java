class PrefixTree {

    static class Trie {
        private Trie[] node = new Trie[26];
        private boolean end = false;

        public Trie(boolean end) {
            this.end = end;
        }
        
        public Trie get(char ch) {
            return node[getIndex(ch)];
        }

        public Trie add(char ch, boolean end) {
            if(get(ch) == null) {
                this.node[getIndex(ch)] = new Trie(end);
            } else {
                this.node[getIndex(ch)].end = (get(ch).end || end);
            }
            return get(ch);
        }

        private int getIndex(char ch) {
            return ch-'a';
        }

        public void setEnd(boolean end) {
            this.end = end;
        }

    }


    private Trie root = new Trie(false);

    public PrefixTree() {
         
    }

    public void insert(String word) {
        Trie root = this.root;
        for(char ch : word.toCharArray()) {
            root = root.add(ch, false);
        }
        root.setEnd(true);
    }

    private Trie getLastNode(String word) {
        boolean exists = false;
        Trie curr = this.root;
        for(char ch : word.toCharArray()) {
            curr = curr.get(ch);
            if(curr == null) {
                return null;
            }
        }
        return curr;
    }

    public boolean search(String word) {
        if(word.length() == 0) return false;
        Trie node = this.getLastNode(word);
        return node == null ? false : node.end;
    }

    public boolean startsWith(String prefix) {
        if(prefix.length() == 0) return true;
        Trie node = this.getLastNode(prefix);
        return node != null;
    }
}
