class WordDictionary {
    static class Node {
        Node[] children;
        char data;
        boolean isEnd;

        Node(char d, boolean isEnd) {
            this.data = d;
            this.children = new Node[26];
            this.isEnd = isEnd;
        }

        Node(char d) {
            this(d, false);
        }

    }

    private Node root;

    public WordDictionary() {
        this.root = new Node('\0');
    }

    public void addWord(String word) {
        Node parent = root;
        for(char ch : word.toCharArray()) {
            if(parent.children[ch - 'a'] == null) {
                Node curr = new Node(ch);
                parent.children[ch - 'a'] = curr;
                parent = curr;
            } else {
                parent = parent.children[ch - 'a'];
            }
        }
        parent.isEnd = true;
    }

    private boolean search(String word, int index, Node parent) {
        if(index >= word.length()) {
            return false;
        } else {
            char ch = word.charAt(index);
            if(ch == '.') {
                boolean accepted = false;
                for(Node child : parent.children) {
                    accepted = accepted || (child == null ? false : (index == word.length() -1) ? child.isEnd : search(word, index+1, child));
                }
                return accepted;
            } else {
                Node curr = parent.children[ch - 'a'];
                if(curr == null) {
                    return false;
                } else if(index == word.length() - 1) {
                    return curr.isEnd;
                } else {
                    return search(word, index+1, curr);
                }
            }
        }
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }
}
