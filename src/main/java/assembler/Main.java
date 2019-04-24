package main.java.assembler;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
//        assumes machine language code is correct
        // need to allow for filepath to be user input later...
        String filePath = args[0];
//        String filePath = "/Users/elana/Documents/nand2tetris/projects/06/max/Max.asm";
//        String filePath = "/Users/elana/Documents/nand2tetris/projects/06/pong/Pong.asm";
//        String filePath = "/Users/elana/Documents/nand2tetris/projects/06/rect/Rect.asm";
//        String filePath = "/Users/elana/Documents/nand2tetris/projects/06/file.asm";
        FileHandler fileHandler = new FileHandler(filePath);
        fileHandler.handle();
    }
}
