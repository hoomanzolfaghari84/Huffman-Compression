package alteredHuffman.trees;

public class ANode {
    int frequency;

    ANode leftChild;
    ANode rightChild;

    public ANode(int frequency) {
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public ANode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(ANode leftChild) {
        this.leftChild = leftChild;
    }

    public ANode getRightChild() {
        return rightChild;
    }

    public void setRightChild(ANode rightChild) {
        this.rightChild = rightChild;
    }
}
