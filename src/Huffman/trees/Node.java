package Huffman.trees;

public class Node { // a basic tree node

    int frequency;  // frequency of the character if the node is a Leaf or just a value to show
                    // the significance of the node's priority in a priority queue (huffman heap) which is the sum of the frequency the children

    Node leftChild;
    Node rightChild;

    public Node(int frequency) {
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
