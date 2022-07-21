package Huffman.trees;

import Huffman.HuffmanMap;
import Huffman.exceptions.HuffmanHeapException;

public class HuffmanHeap {

    Node[] nodes; //main tree nodes

    int size; //number of nodes stored on the heap , it's not necessarily equal to nodes.length

    public HuffmanHeap(HuffmanMap huffmanMap){
        int arraySize =1; //the initial size of the main tree nodes which will be the initial nodes.length

        size = huffmanMap.getSize();

        while (arraySize<size){
            arraySize = arraySize *2; //making sure array size is a power of 2 and so dividable by 2
        }

        nodes = new Node[arraySize];
        int i = 0;
        for (char character:huffmanMap.getCharacters()) {

            nodes[i] = new Leaf(huffmanMap.getFrequency(character),character); // at first the heap will contain only the leaves which are nodes with characters

            i++;
        }

        for (int j = i+1; j < arraySize; j++) {  //in general , we should fill the rest of the array with null but java does that probably (I did it just to be sure)
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

    private void makeNodesToHeap(){ // this is based on the method used in Dr.Moghadasi text book
        for (int i = (size-1)/2 -1; i >= 0; i--) {
            minHeapify(i);
        }
    }

    private void minHeapify(int index){ // maintains the heap property assuming it's already maintained for nodes after index
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

    //adds a Node to heap
    public void push(Node node){
        size++;

        if(size>nodes.length){ //check to see if we should increase the length of nodes array TODO make a load factor thingy
            increaseLength();
        }

        nodes[size-1] = node;
        int i = size-1;
        while (i>0 && nodes[i].frequency<nodes[parent(i)].frequency){
            swap(i,parent(i));
            i = parent(i);
        }

    }

    private void swap(int i,int j){ // swap to nodes in array without caring about the heap properties
        Node node = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = node;
    }

    //removes the minimum item and returns its node
    public Node pop(){
        if(size == 0)
            return null;

        Node node = nodes[0];  //putting the last one in the place of the min
        nodes[0] = nodes[size-1];
        nodes[size-1] = null;
        size--;

        minHeapify(0); //we need to heapfy because of the last swap


        if(size < nodes.length/2){ //check to see if we should decease the length of nodes array TODO make a load factor thingy
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

    private void increaseLength(){  // doubles the length of the nodes array
        Node[] nodes1 = new Node[nodes.length*2];
        for (int i = 0; i < nodes.length; i++) {
            nodes1[i] = nodes[i];
        }

        nodes = nodes1;
    }
    private void decreaseSize(){ // halves the length of the nodes array
        Node[] nodes1 = new Node[nodes.length/2];
        for (int i = 0; i < nodes1.length; i++) {
            nodes1[i] = nodes[i];
        }
        nodes = nodes1;
    }
    //returning the number of nodes in the array
    public int getSize(){
        return this.size;
    }

}
