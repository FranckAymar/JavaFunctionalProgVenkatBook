package playground.executeAroundMethodPattern;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEAM {

    private final FileWriter fileWriter;

    private FileWriterEAM(final String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }

    private void close() throws IOException {
        System.out.println("close called method");
        fileWriter.close();
    }

    public void writeStuff(String message) throws IOException {
        fileWriter.write(message);
    }

    public static void use(final String fileName,
                           final UseInstance<FileWriterEAM, IOException> block) throws IOException {

        FileWriterEAM fileWriterEAM = new FileWriterEAM(fileName);
        try {
            block.accept(fileWriterEAM);
        }finally {
            fileWriterEAM.close();
        }
    }

    static void main() throws IOException {
        FileWriterEAM.use(
                "test.txt",
                (fileWriter)-> fileWriter.writeStuff("Hello world")
        );
    }
}
