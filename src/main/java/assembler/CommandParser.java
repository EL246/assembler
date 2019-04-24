package main.java.assembler;

import main.java.assembler.command.Command;
import main.java.assembler.file.SymbolTable;

public class CommandParser {

    public static CommandType getCommandType(String line) {
        System.out.println("first character: " + line.charAt(0));
        switch (line.charAt(0)) {
            case '@':
                return CommandType.A_COMMAND;
            case '(':
                return CommandType.L_COMMAND;
            default:
                return CommandType.C_COMMAND;
        }
    }

    public static void parseLabel(String line, SymbolTable symbols, int lineCount) {
        String label = CommandFactory.getCommand(line, CommandType.L_COMMAND).processAndGetValue(symbols);
        symbols.addSymbol(label, lineCount + 1);
    }

    public static String parseCommand(String line, SymbolTable symbols) {
        CommandType commandType = getCommandType(line);
        Command command = CommandFactory.getCommand(line, commandType);
        return command.processAndGetValue(symbols);
    }
}
