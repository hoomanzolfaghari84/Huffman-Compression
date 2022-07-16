package Huffman.trees;

public class HuffmanTree {

    Node root;

    String[] codes;
    char[] chars;

    public HuffmanTree(Node root,char[] chars) {
        this.root = root;
        this.chars = chars;

        generateCodes();
    }

    // generate the binary codes for each character in the text
    private void generateCodes(){

        codes = new String[chars.length];
        recursiveCodeFinder("",root);
    }

    private void recursiveCodeFinder(String code, Node node){
        if (node == null) return;

        if(node instanceof Leaf){
            Leaf leaf = (Leaf) node;
            for (int i = 0; i < codes.length ; i++) {  // TODO replace with a map
                if(chars[i] == leaf.aChar){
                    codes[i] = code;
                    return;
                }
            }
        }

        recursiveCodeFinder(code+"0",node.leftChild);
        recursiveCodeFinder(code+"1",node.rightChild);

    }

    public HuffmanTree() {
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public String[] getCodes() {
        return codes;
    }
}
