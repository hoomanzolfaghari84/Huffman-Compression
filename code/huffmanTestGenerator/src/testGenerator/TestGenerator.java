package testGenerator;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class TestGenerator {
    public String generateTest(int numberOfBytes){
        // java uses UTF-8
        // we are using utf-8 character encoding where each character uses a maximum of 1 byte
        byte[] bytes = new byte[numberOfBytes];
        new Random().nextBytes(bytes);
        return new String(bytes, StandardCharsets.UTF_8);


    }
    public String generateAlphanumericText(int numberOfCharacters){

        return null;
    }

}
