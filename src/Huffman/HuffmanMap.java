package Huffman;

import java.util.LinkedList;
import java.util.List;

public class HuffmanMap {

    final int TABLE_SIZE;

    MapNode[] mapNodes;


    public HuffmanMap(int TABLE_SIZE) {
        this.TABLE_SIZE = TABLE_SIZE;

        mapNodes = new MapNode[TABLE_SIZE];
    }

    public HuffmanMap() {
        TABLE_SIZE = 16;

        mapNodes = new MapNode[TABLE_SIZE];
    }

    public int getFrequency(char character){
        int index = hash(character);

        if(mapNodes[index] == null) return 0;

        MapNode mapNode = mapNodes[index];

        while (mapNode.next != null){
            if(mapNode.character == character)
                return mapNode.frequency;
        }

        if(mapNode.character == character) return mapNode.frequency;

        return 0;
    }

    public String getCode(char character){
        int index = hash(character);

        if(mapNodes[index] == null) return null;

        MapNode mapNode = mapNodes[index];

        while (mapNode.next != null){
            if(mapNode.character == character)
                return mapNode.code;
        }

        if(mapNode.character == character) return mapNode.code;

        return null;
    }

    public void put(char character, String code){
        int index = hash(character);

        if(mapNodes[index] == null){
            mapNodes[index] = new MapNode(character);
            mapNodes[index].code = code;
            return;
        }
        MapNode mapNode = mapNodes[index];
        while (mapNode.next != null){
            if (mapNode.character == character){
                mapNode.code = code;
                return;
            }
            mapNode = mapNode.next;
        }

        if (mapNode.character == character){
            mapNode.code = code;
            return;
        }

        mapNode.next = new MapNode(character);
        mapNode.next.code = code;
    }

    public void put(char character, int frequency){
        int index = hash(character);

        if(mapNodes[index] == null){
            mapNodes[index] = new MapNode(character);
            mapNodes[index].frequency = frequency;
            return;
        }
        MapNode mapNode = mapNodes[index];
        while (mapNode.next != null){
            if (mapNode.character == character){
                mapNode.frequency = frequency;
                return;
            }
            mapNode = mapNode.next;
        }

        if (mapNode.character == character){
            mapNode.frequency = frequency;
            return;
        }

        mapNode.next = new MapNode(character);
        mapNode.next.frequency = frequency;

    }

    public void add(char character){
        int index = hash(character);

        if(mapNodes[index] == null){
            mapNodes[index] = new MapNode(character);
            mapNodes[index].frequency = 1;
            return;
        }

        MapNode mapNode = mapNodes[index];
        while (mapNode.next != null){
            if (mapNode.character == character){
                mapNode.frequency = mapNode.frequency + 1;
                return;
            }
            mapNode = mapNode.next;
        }

        if (mapNode.character == character){
            mapNode.frequency = mapNode.frequency + 1;
            return;
        }

        mapNode.next = new MapNode(character);
        mapNode.next.frequency = 1;
    }

    private int hash(char character){
        return Character.getNumericValue(character) % TABLE_SIZE;
    }

    static class MapNode{
        char character;
        int frequency;
        String code;

        MapNode next;

        public MapNode(char character) {
            this.character = character;
        }

        public char getCharacter() {
            return character;
        }

        public void setCharacter(char character) {
            this.character = character;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public MapNode getNext() {
            return next;
        }

        public void setNext(MapNode next) {
            this.next = next;
        }
    }
}
