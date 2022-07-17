package Huffman;

import Huffman.trees.HuffmanTree;

public class HuffmanCompressed {

    HuffmanTree huffmanTree;
    String compressedText;

    public HuffmanCompressed(HuffmanTree huffmanTree, String compressedText) {
        this.huffmanTree = huffmanTree;
        this.compressedText = compressedText;
    }

    public HuffmanTree getHuffmanTree() {
        return huffmanTree;
    }

    public String getCompressedText() {
        return compressedText;
    }
}

