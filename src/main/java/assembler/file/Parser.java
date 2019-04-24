package main.java.assembler.file;

import main.java.assembler.CommandParser;
import main.java.assembler.CommandType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Parser {
    private File file;
    private List<String> linesToAdd;
    private SymbolTable symbolTable;
    private boolean parseOnlyLabels;
    private int lineCount = -1;

    Parser(String filePath) {
        file = new File(filePath);
        symbolTable = new SymbolTable();
        linesToAdd = new ArrayList<>();
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

        if (!line.isEmpty()) {
            CommandType commandType = CommandParser.getCommandType(line);
            boolean isLCommand = commandType.equals(CommandType.L_COMMAND);

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
            String newLine = CommandParser.parseCommand(line, symbolTable);
            System.out.println("binary line: " + newLine);
            linesToAdd.add(newLine);
        }
    }

    private void parseLabelCommand(String line, boolean isLCommand) {
        if (isLCommand) {
            CommandParser.parseLabel(line, symbolTable, lineCount);
        } else {
            lineCount++;
        }
    }

    private String removeEmptyOrCommentedLines(String line) {
        String[] values = line.split("//", 2); // better way to parse this?
        return values[0].replaceAll("\\s+", "");
    }
}
