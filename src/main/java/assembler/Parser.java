package main.java.assembler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Parser {
    private File file;
    private List<String> linesToAdd;
    private HashMap<String, Integer> symbols;
    private boolean parseOnlyLabels;
    private int lineCount = -1;

    Parser(String filePath) {
        file = new File(filePath);
        symbols = new HashMap<>();
        linesToAdd = new ArrayList<>();
        initSymbols();
    }

    private void initSymbols() {
        symbols.put("R0", 0);
        symbols.put("R1", 1);
        symbols.put("R2", 2);
        symbols.put("R3", 3);
        symbols.put("R4", 4);
        symbols.put("R5", 5);
        symbols.put("R6", 6);
        symbols.put("R7", 7);
        symbols.put("R8", 8);
        symbols.put("R9", 9);
        symbols.put("R10", 10);
        symbols.put("R11", 11);
        symbols.put("R12", 12);
        symbols.put("R13", 13);
        symbols.put("R14", 14);
        symbols.put("R15", 15);

        symbols.put("SCREEN", 16384);
        symbols.put("KBD", 24576);
        symbols.put("SP", 0);
        symbols.put("LCL", 1);
        symbols.put("ARG", 2);
        symbols.put("THIS", 3);
        symbols.put("THAT", 4);
    }

    List<String> parse(boolean parseOnlyLabels) throws FileNotFoundException {
        this.parseOnlyLabels = parseOnlyLabels;
        parse();
        return linesToAdd;
    }

    private void parse() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            parseLine(scanner.nextLine());
        }
    }

    private void parseLine(String line) {
        line = removeEmptyOrCommentedLines(line);

//        if (line != null && !line.isEmpty()) {
        if (!line.isEmpty()) {
            CommandType commandType = CommandParser.getCommandType(line);
            boolean isLCommand = commandType.equals(CommandType.LCOMMAND);

            if (parseOnlyLabels) {
                parseLabelCommand(line, isLCommand);
            } else {
                System.out.println("original line: " + line);
                parseBinaryCommand(line, isLCommand);
            }
        }
    }

    private void parseBinaryCommand(String line, boolean isLCommand) {
        if (!isLCommand) {
            String newLine = CommandParser.parseCommand(line, symbols);
            System.out.println("binary line: " + newLine);
            linesToAdd.add(newLine);
        }
    }

    private void parseLabelCommand(String line, boolean isLCommand) {
        if (isLCommand) {
            CommandParser.parseLabel(line, symbols, lineCount);
        } else {
            lineCount++;
        }
    }

    private String removeEmptyOrCommentedLines(String line) {
        String[] values = line.split("//", 2); // better way to parse this?
        return values[0].replaceAll("\\s+", "");
    }
}
