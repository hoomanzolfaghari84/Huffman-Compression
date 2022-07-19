package alteredHuffman.trees;

public class ALeaf extends ANode{

    char character;


    public ALeaf(int frequency,char character) {
        super(frequency);
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}
