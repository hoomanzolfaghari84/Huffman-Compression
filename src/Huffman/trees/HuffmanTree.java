package Huffman.trees;

public class HuffmanTree {

    Node root;

    String[] codes;
    char[] chars;

    public HuffmanTree(Node root,char[] chars) {
        this.root = root;
    }

    private String[] generateCodes(char[] chars,HuffmanTree huffmanTree){

        String code = "";

        String[] codes = new String[chars.length];

        for (int i = 0; i < chars.length; i++) {

        }


        return codes;
    }

    public HuffmanTree() {
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
