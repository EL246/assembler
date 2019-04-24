package main.java.assembler;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        FileHandler fileHandler = new FileHandler(filePath);
        fileHandler.handle();
    }
}
