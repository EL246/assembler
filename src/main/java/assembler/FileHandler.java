package main.java.assembler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

class FileHandler {
    private Parser parser;
    private FileCreator fileCreator;
    private String filePath;

    FileHandler(String filePath) {
        this.filePath = filePath;
        parser = new Parser(filePath);
        fileCreator = new FileCreator();
    }

    void handle() throws IOException {
        parser.parse(true);

        List<String> linesToAdd = parser.parse(false);
        String newFilePath = filePath.replace(".asm", ".hack");
        fileCreator.createFile(newFilePath, linesToAdd);
    }
}
