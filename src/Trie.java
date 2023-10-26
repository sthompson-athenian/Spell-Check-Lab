public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a String into the Trie
    // Code is provided
    public void add(String str) {
        // We will start at the root
        TrieNode current = root;

        // Then, we loop through the String
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';

            // We make a new node, if necessary
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            // We update the current node
            current = current.children[index];
        }

        // We set isWord of the last node to be true
        current.isWord = true;
    }

    // Prints out the Trie
    // Code is provided
    public void print() {
        printRec(this.root, "");
    }

    // Recursive code that actually prints out the Trie
    // Code is provided
    public void printRec(TrieNode current, String str) {
        if (current == null) {
            return;
        }
        else if (current.isWord) {
            System.out.println(str);
        }

        for (int i = 0; i < 26; i++) {
            TrieNode child = current.children[i];
            char c1 = (char) ('a' + i);
            printRec(child, str + c1);
        }
    }

    // Should iterate through the str, and then print out
    // all of the Strings that start with str
    public void autoComplete(String str) {
        TrieNode currNode = root;
        // Find the end of the prefix in the Trie.
        for (char c : str.toCharArray()) {
            currNode = currNode.children[c - 'a'];
            if (currNode == null) {
                return;
            }
        }

        // Print out the suggestions
        printRec(currNode, str);
    }

    public static void main(String[] args) {

    }
}

// Each TrieNode keeps track of if it is the end
// of a word, as well as an array of 26 possible children
class TrieNode {
    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}