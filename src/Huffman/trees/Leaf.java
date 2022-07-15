package Huffman.trees;

public class Leaf extends Node{
    char aChar;

    public Leaf(char aChar,int frequency) {
        super(frequency);
        this.aChar = aChar;
    }
}
