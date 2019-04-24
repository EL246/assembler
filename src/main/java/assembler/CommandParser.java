package main.java.assembler;

import main.java.assembler.command.Command;
import main.java.assembler.file.SymbolTable;

public class CommandParser {

    public static void parseLabel(String line, SymbolTable symbols, int lineCount) {
        String label = CommandFactory.getCommand(line).processAndGetValue(symbols);
        symbols.addSymbol(label, lineCount + 1);
    }

    public static String parseCommand(String line, SymbolTable symbols) {
        Command command = CommandFactory.getCommand(line);
        return command.processAndGetValue(symbols);
    }

    public static boolean isLCommand(String line) {
        CommandType commandType = CommandFactory.getCommandType(line);
        return commandType.equals(CommandType.L_COMMAND);
    }
}
