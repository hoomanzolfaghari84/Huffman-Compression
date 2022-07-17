package Huffman.trees;

import Huffman.HuffmanMap;
import Huffman.exceptions.HuffmanHeapException;

public class HuffmanHeap {
    Node[] nodes;
    int size;

    public HuffmanHeap(HuffmanMap huffmanMap){
        int arraySize =1;

        size = huffmanMap.getSize();

        while (arraySize<size){
            arraySize = arraySize *2;
        }



        nodes = new Node[arraySize];
        int i = 0;
        for (char character:huffmanMap.getCharacters()) {

            nodes[i] = new Leaf(character,huffmanMap.getFrequency(character));
            i++;

        }

        for (int j = i+1; j < arraySize; j++) {
            nodes[j] = null;
        }


        makeNodesToHeap();
    }

    public void printNodes(){
        System.out.println("size is"+size);
        for (int i = 0; i < nodes.length; i++) {
            if(nodes[i]==null)
                System.out.println("null");
            else System.out.println(nodes[i].frequency);
        }
    }
    private void makeNodesToHeap(){
        for (int i = (size-1)/2 -1; i >= 0; i--) {
            minHeapify(i);
        }
    }
    private void minHeapify(int index){
        int left = leftChild(index);
        int right = rightChild(index);
        int littleChild;
        if(size>left && nodes[index].frequency>nodes[left].frequency){
            littleChild = left;
        }else littleChild = index;

        if(size>right && nodes[littleChild].frequency>nodes[right].frequency) {
            littleChild = right;
        }

        if(littleChild != index){
            swap(index,littleChild);

            minHeapify(littleChild);
        }

    }

    public int parent(int index){
        return (index-1)/2;
    }
    public int leftChild(int index){
        return 2*index +1;
    }
    public int rightChild(int index){
        return 2*index +2;
    }

    //adds an item to heap
    public void push(Node node){
        size++;
        if(size>nodes.length){
            increaseLength();
        }

        nodes[size-1] = node;
        int i = size-1;
        while (i>0 && nodes[i].frequency<nodes[parent(i)].frequency){
            swap(i,parent(i));
            i = parent(i);
        }

    }
    private void swap(int i,int j){
        Node node = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = node;
    }

    //removes the minimum item and returns its node
    public Node pop(){
        if(size == 0)
            return null;

        Node node = nodes[0];
        nodes[0] = nodes[size-1];
        nodes[size-1] = null;
        size--;

        minHeapify(0);


        if(size < nodes.length/2){
            decreaseSize();
        }

        return node;

    }

    //returns the minimum node without removing it
    public Node peek(){
        return nodes[0];
    }
    public boolean isEmpty(){
        return nodes[0]==null;
    }

    private void increaseLength(){
        Node[] nodes1 = new Node[nodes.length*2];
        for (int i = 0; i < nodes.length; i++) {
            nodes1[i] = nodes[i];
        }

        nodes = nodes1;
    }
    private void decreaseSize(){
        Node[] nodes1 = new Node[nodes.length/2];
        for (int i = 0; i < nodes1.length; i++) {
            nodes1[i] = nodes[i];
        }
        nodes = nodes1;
    }

    public int getSize(){
        return this.size;
    }

}
