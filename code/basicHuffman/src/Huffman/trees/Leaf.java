package Huffman.trees;

public class Leaf extends Node{ // a Node with a character field(attribute)
    char character;

    public Leaf(int frequency,char character) {
        super(frequency);
        this.character = character;
//        this.leftChild = null;   this part is not needed in java
//        this.rightChild = null;
    }

    public char getCharacter() {
        return character;
    }
}
