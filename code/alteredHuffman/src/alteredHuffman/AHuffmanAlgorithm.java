package alteredHuffman;

import alteredHuffman.trees.AHuffmanHeap;
import alteredHuffman.trees.AHuffmanTree;
import alteredHuffman.trees.ALeaf;
import alteredHuffman.trees.ANode;

public class AHuffmanAlgorithm {

    private double lossFactor = 0.1;
    public static final char REPLACEMENT_CHARACTER = '\uFFFD';

    public AHuffmanCompressed compressText(String text){
        AHuffmanMap huffmanMap = findFrequencies(text);
        AHuffmanTree huffmanTree = makeTree(huffmanMap);
        findCodes(huffmanMap,huffmanTree);

        StringBuilder compressedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            String s = huffmanMap.getCode(text.charAt(i));
            if(s == null){
                compressedText.append(huffmanMap.getCode(AHuffmanAlgorithm.REPLACEMENT_CHARACTER));
            }else compressedText.append(s);

        }


        return new AHuffmanCompressed(huffmanTree,compressedText.toString());
    }

    private void findCodes(AHuffmanMap huffmanMap,AHuffmanTree huffmanTree){
        recursiveCodeFinder("",huffmanTree.getRoot(),huffmanMap);
    }
    private void recursiveCodeFinder(String code, ANode node,AHuffmanMap huffmanMap){
        if (node == null) return;

        if(node instanceof ALeaf){
            ALeaf leaf = (ALeaf) node;
            huffmanMap.put(leaf.getCharacter(),code);
        }

        recursiveCodeFinder(code+"0",node.getLeftChild(),huffmanMap);
        recursiveCodeFinder(code+"1",node.getRightChild(),huffmanMap);

    }

    private AHuffmanMap findFrequencies(String text){
        AHuffmanMap huffmanMap = new AHuffmanMap();
        for (char character: text.toCharArray()) {
            huffmanMap.add(character);
        }

        return huffmanMap;
    }

    private AHuffmanTree makeTree(AHuffmanMap huffmanMap){
        AHuffmanHeap huffmanHeap = new AHuffmanHeap(huffmanMap);

        for (int i = 1; i < huffmanMap.getSize()*lossFactor; i++) {
            huffmanHeap.pop();
        }

        huffmanHeap.push(new ALeaf(0,AHuffmanAlgorithm.REPLACEMENT_CHARACTER));

        while (huffmanHeap.getSize()> 1){
            ANode left = huffmanHeap.pop();
            ANode right = huffmanHeap.pop();

            ANode node = new ANode(left.getFrequency()+right.getFrequency());
            node.setLeftChild(left);
            node.setRightChild(right);

            huffmanHeap.push(node);

        }

        return new AHuffmanTree(huffmanHeap.pop());
    }

    public double getLossFactor() {
        return lossFactor;
    }

    public void setLossFactor(double lossFactor) throws Exception {
        if(lossFactor>=0 && lossFactor <1 )
            this.lossFactor = lossFactor;
        else throw new Exception();
    }

    public String extractText(AHuffmanCompressed huffmanCompressed){

        ANode node = huffmanCompressed.getHuffmanTree().getRoot();

        StringBuilder text = new StringBuilder();

        for (int i = 0; i < huffmanCompressed.getCompressedText().length(); i++) {
            char c = huffmanCompressed.getCompressedText().charAt(i);
            if(c == '0'){
                node = node.getLeftChild();
            }else {
                node = node.getRightChild();
            }

            if(node instanceof ALeaf){
                ALeaf leaf = (ALeaf) node;
                text.append(leaf.getCharacter());

                node = huffmanCompressed.getHuffmanTree().getRoot();
            }

        }
        return text.toString();
    }
}
