package Huffman;

import Huffman.exceptions.HuffmanAlgorithmException;
import Huffman.exceptions.HuffmanHeapException;
import Huffman.trees.HuffmanHeap;
import Huffman.trees.HuffmanTree;
import Huffman.trees.Node;

public class HuffmanAlgorithm {

    // returns the compressed format of the text consisting of bits and a tree


    public HuffmanCompressed compressText(String text,char[] chars, int[] frequencies) throws HuffmanAlgorithmException {
        if(chars.length != frequencies.length){
            throw new HuffmanHeapException();
        }
        if(text.isEmpty() || chars.length==0){
            throw new HuffmanAlgorithmException();
        }



        return null;
    }




    private HuffmanTree makeTree(char[] chars, int[] frequencies) throws HuffmanHeapException {
        HuffmanHeap huffmanHeap = new HuffmanHeap(chars,frequencies);

        while (huffmanHeap.getSize()>1){
            Node left = huffmanHeap.pop();
            Node right = huffmanHeap.pop();

            Node node = new Node(left.getFrequency()+right.getFrequency());
            node.setLeftChild(left);
            node.setRightChild(right);

            huffmanHeap.push(node);

        }

        return new HuffmanTree(huffmanHeap.pop(),chars);
    }



    // returns the text extracted from compressed text which was compressed by huffman algorithm and consists of bits and a tree
    public String extractText(HuffmanCompressed huffmanCompressed){

        return null;
    }


}

