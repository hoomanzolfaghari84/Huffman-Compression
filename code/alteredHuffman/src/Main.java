import alteredHuffman.AHuffmanAlgorithm;
import alteredHuffman.AHuffmanCompressed;

public class Main {
    public static void main(String[] args) throws Exception {
        String text = "hello world ! \nis this \"awesome\" or what \\bob :)";;
        AHuffmanAlgorithm huffmanAlgorithm = new AHuffmanAlgorithm();
        huffmanAlgorithm.setLossFactor(0.5);
        AHuffmanCompressed huffmanCompressed = huffmanAlgorithm.compressText(text);
        System.out.println(huffmanCompressed.getCompressedText());
        System.out.println(huffmanAlgorithm.extractText(huffmanCompressed));
    }
}
