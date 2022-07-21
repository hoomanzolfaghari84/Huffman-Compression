package Huffman;

import Huffman.trees.HuffmanTree;

public class HuffmanCompressed { // the compressed file that can be decompressed by HuffmanAlgorithm using the tree to give the original text

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

