package main.java.assembler.file;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileHandler {
    private Parser parser;
    private String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
        parser = new Parser(filePath);
    }

    public void handle() throws IOException {
        List<String> linesToAdd = getLinesToAdd();

        String newFilePath = filePath.replace(".asm", ".hack");
        createFile(newFilePath, linesToAdd);
    }

    private List<String> getLinesToAdd() throws FileNotFoundException {
        parser.parse(true);
        return parser.parse(false);
    }

    private void createFile(String filePath, List<String> linesToAdd) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        for (String line : linesToAdd) {
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }
}
