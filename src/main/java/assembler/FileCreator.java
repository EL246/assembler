package main.java.assembler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class FileCreator {
    void createFile(String filePath, List<String> linesToAdd) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        for (String line : linesToAdd) {
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }
}
