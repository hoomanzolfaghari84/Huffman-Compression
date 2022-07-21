package testGenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class TestFileManager {
    File testsDirectory;

    public TestFileManager() {
        testsDirectory = new File(Configs.getInstance().getTestsDirectoryAddress());
        testsDirectory.mkdirs();
    }
    public void saveTestsFile(String[] texts){
        for (String text:texts) {
            saveTestFile(text);
        }
    }
    public void saveTestFile(String text){
        int testNumber = Objects.requireNonNull(testsDirectory.listFiles()).length + 1;
        File testFile = new File(testsDirectory+"/testNumber"+testNumber+".txt");
        try {
            while (!testFile.createNewFile()){
                testNumber++;
                testFile = new File(testsDirectory+"/testNumber"+testNumber+".txt");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fileWriter = new FileWriter(testFile);
            fileWriter.write(text);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
