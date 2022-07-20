package Huffman.trees;

import Huffman.HuffmanMap;

public class HuffmanTree {
    // if we are sending the tree itself along with the compressed text then
    //it is important to make it has as little information as possible which also affects the structure of the nodes,
    //but it would be better to send a fixed and simplified version of the tree since it only needs to be read and
    // not modified by the decompressor

    Node root; // root node of the tree


    public HuffmanTree() {

    }

    public HuffmanTree(Node root) {
        this.root = root;

    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }



}
