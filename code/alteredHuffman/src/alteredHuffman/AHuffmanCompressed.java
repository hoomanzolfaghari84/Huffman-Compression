package alteredHuffman;

import alteredHuffman.trees.AHuffmanTree;

public class AHuffmanCompressed {
    AHuffmanTree huffmanTree;
    String compressedText;

    public AHuffmanCompressed(AHuffmanTree huffmanTree, String compressedText) {
        this.huffmanTree = huffmanTree;
        this.compressedText = compressedText;
    }

    public AHuffmanTree getHuffmanTree() {
        return huffmanTree;
    }

    public String getCompressedText() {
        return compressedText;
    }
}
