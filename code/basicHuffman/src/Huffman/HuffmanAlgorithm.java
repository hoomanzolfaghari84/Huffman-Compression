package Huffman;

import Huffman.exceptions.HuffmanAlgorithmException;
import Huffman.exceptions.HuffmanHeapException;
import Huffman.trees.HuffmanHeap;
import Huffman.trees.HuffmanTree;
import Huffman.trees.Leaf;
import Huffman.trees.Node;

public class HuffmanAlgorithm {

    //compress the given text and return the compressed binary code along with its huffman tree in a HuffmanCompressed object
    public HuffmanCompressed compressText(String text){

        // if text is empty there is really no  need for compression// if text is empty there is really no  need for compression
        if(text.isEmpty()){
            return new HuffmanCompressed(null,"");
        }

        HuffmanMap huffmanMap = findFrequencies(text);

        HuffmanTree huffmanTree = makeTree(huffmanMap);

        findCodes(huffmanMap,huffmanTree);


        StringBuilder compressedText = new StringBuilder();  // StringBuilder is for java, and it's not necessary for the correctness of the code . we can also use string directly

        // we replace each character with its corresponding binary code
        for (int i = 0; i < text.length(); i++) {
            compressedText.append(huffmanMap.getCode(text.charAt(i)));
        }


        return new HuffmanCompressed(huffmanTree,compressedText.toString());
    }

    private void findCodes(HuffmanMap huffmanMap,HuffmanTree huffmanTree){

        // if there is only one type of character used in the text we can't use the binary tree and coding doesn't make sense,
        // so we just use zeros for that character or if its better we can just send a number with one instance of the character

        if(huffmanMap.size==1){

            huffmanMap.put(((Leaf)huffmanTree.getRoot()).getCharacter(),"0");

        } else recursiveCodeFinder("",huffmanTree.getRoot(),huffmanMap);

    }


    private void recursiveCodeFinder(String code, Node node,HuffmanMap huffmanMap){
        if (node == null) return;

        // each character is a leaf and codes are made using the path from root to a leaf which is unique in a tree , so the code for each character will be unique
        if(node instanceof Leaf){
            Leaf leaf = (Leaf) node;
            huffmanMap.put(leaf.getCharacter(),code);  // put the code as a value on the map for the key being the character of the leaf
        }

        recursiveCodeFinder(code+"0",node.getLeftChild(),huffmanMap); // when we go left on the path we put 0
        recursiveCodeFinder(code+"1",node.getRightChild(),huffmanMap); // when we go right on the path we put 1

    }

    // finds the frequency of each character in the text and puts it in a HuffmanMap object
    private HuffmanMap findFrequencies(String text){

        HuffmanMap huffmanMap = new HuffmanMap();

        for (char character: text.toCharArray()) {
            huffmanMap.add(character);
        }

        return huffmanMap;
    }

    // make a huffman tree from characters in the given huffman map
    private HuffmanTree makeTree(HuffmanMap huffmanMap){

        //first initialize a HuffmanHeap (priority queue) with all the characters prioritized by their frequencies
        //each character will be stored in a Leaf which is a subclass of Node which is a node of the huffman binary tree
        // all nodes have a frequency attribute by which they will be prioritized in the huffman heap
        HuffmanHeap huffmanHeap = new HuffmanHeap(huffmanMap);

        while (huffmanHeap.getSize()>1){ // until there is only one tree node left

            // take the two nodes with the least frequencies
            Node left = huffmanHeap.pop();
            Node right = huffmanHeap.pop();

            //make a new node to be the parent of the two popped nodes and set its frequency equal to the sum of the frequencies of the popped nodes
            Node node = new Node(left.getFrequency()+right.getFrequency());
            node.setLeftChild(left);
            node.setRightChild(right);

            huffmanHeap.push(node);

        }

        return new HuffmanTree(huffmanHeap.pop()); // set the last node (with the maximum frequency) as the root
    }


    // returns the text extracted from compressed text which was compressed by huffman algorithm and consists of bits
    // it uses the HuffmanCompressed object which holds the compressed text and its corresponding tree
    public String extractText(HuffmanCompressed huffmanCompressed){
        //if the text was empty
        if(huffmanCompressed.getCompressedText().isEmpty()){
            return "";
        }

        //if the text had only one type of character TODO ...
        if(huffmanCompressed.getHuffmanTree().getRoot() instanceof Leaf){
            String text = "";
            char c = ((Leaf) huffmanCompressed.getHuffmanTree().getRoot()).getCharacter();
            for (int i = 0; i < huffmanCompressed.getCompressedText().length(); i++) {
                text+= c;
            }
            return text;
        }

        Node node = huffmanCompressed.getHuffmanTree().getRoot(); // for each character we have to start from root and reach the leaf of that character

        StringBuilder text = new StringBuilder();

        // based on the way we created binary codes from the tree when we see a 0 we go left and 1 we go right .
        // when we reach a node that is a leaf add its character to the text and start from the root again
        // to check if a node is a leaf we could just see if both its children are null instead of using the java instanceof operator

        for (int i = 0; i < huffmanCompressed.getCompressedText().length(); i++) {

            char c = huffmanCompressed.getCompressedText().charAt(i);

            if(c == '0'){
                node = node.getLeftChild();
            }else {
                node = node.getRightChild();
            }

            if(node instanceof Leaf){
                Leaf leaf = (Leaf) node;
                text.append(leaf.getCharacter());

                node = huffmanCompressed.getHuffmanTree().getRoot(); // for each character we have to start from root and reach the leaf of that character
            }

        }

        return text.toString();
    }


}

