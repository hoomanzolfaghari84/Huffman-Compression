import testGenerator.TestGenerator;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new TestGenerator().generateTest(7));
//        String h = "hello";
//        System.out.println(Integer.toHexString(h.codePointAt(0)));
//        System.out.println(Arrays.toString(h.getBytes(StandardCharsets.UTF_8)));
//        System.out.println(StandardCharsets.UTF_8.encode("hello").get(1));
//        System.out.println(Integer.toBinaryString(101));
//        System.out.println(Integer.toBinaryString('e'));
    }
}
