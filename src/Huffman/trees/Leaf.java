package Huffman.trees;

public class Leaf extends Node{
    char character;

    public Leaf(char character,int frequency) {
        super(frequency);
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}
