import Huffman.HuffmanAlgorithm;
import Huffman.HuffmanMap;
import Huffman.exceptions.HuffmanHeapException;
import Huffman.trees.HuffmanHeap;
import Huffman.trees.Node;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        String text = "hello";

        HuffmanAlgorithm huffmanAlgorithm = new HuffmanAlgorithm();



        System.out.println(huffmanAlgorithm.compressText(text).getCompressedText());


    }
}
