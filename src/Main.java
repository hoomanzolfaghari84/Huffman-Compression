import Huffman.exceptions.HuffmanHeapException;
import Huffman.trees.HuffmanHeap;
import Huffman.trees.Node;

public class Main {
    public static void main(String[] args) {
        char[] chars = new char[]{'a','b','c','f','r'};
        int[] ints = new int[]{5,3,9,4,2};

        try {
            HuffmanHeap huffmanHeap = new HuffmanHeap(chars,ints);

            huffmanHeap.printNodes();
            System.out.println("done");

            huffmanHeap.pop();
            huffmanHeap.printNodes();
            System.out.println("done");

            huffmanHeap.push(new Node(6));
            huffmanHeap.printNodes();
            System.out.println("done");

            huffmanHeap.push(new Node(1));
            huffmanHeap.printNodes();
            System.out.println("done");

            huffmanHeap.push(new Node(15));
            huffmanHeap.printNodes();
            System.out.println("done");


//            for (int i = 0; i < 6; i++) {
//                huffmanHeap.pop();
//                huffmanHeap.printNodes();
//                System.out.println("done");
//            }

        } catch (HuffmanHeapException e) {
            e.printStackTrace();
        }


    }
}
