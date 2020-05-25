class Trie {

    private class TrieNode {
        private HashMap<Character, TrieNode> map;
        private boolean endOfWord;
        
        TrieNode() {
            map = new HashMap<>();
            endOfWord = false;
        }
        
    }
    private final TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode node = current.map.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.map.put(ch, node);
            }
            current = node;
        }
        current.endOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode node = current.map.get(ch);
            if(node == null) {
                return false;
            }
            current = node;
        }
        return current.endOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            TrieNode node = current.map.get(ch);
            if(node == null) {
                return false;
            }
            current = node;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
