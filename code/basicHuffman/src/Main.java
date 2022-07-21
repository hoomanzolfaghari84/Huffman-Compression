import Huffman.HuffmanAlgorithm;
import Huffman.HuffmanCompressed;
import Huffman.HuffmanMap;
import Huffman.exceptions.HuffmanHeapException;
import Huffman.trees.HuffmanHeap;
import Huffman.trees.Node;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

//        String text = "hello world ! \nis this \"awesome\" or what \\bob :)";
//        String text = " hello سلام" ;
        String text = "";
//        String text = "w�\u0019oy�i";


        HuffmanAlgorithm huffmanAlgorithm = new HuffmanAlgorithm();

        HuffmanCompressed huffmanCompressed = huffmanAlgorithm.compressText(text);

        System.out.println(huffmanCompressed.getCompressedText());

        System.out.println(huffmanAlgorithm.extractText(huffmanCompressed));

    }
}
