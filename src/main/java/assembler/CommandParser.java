package main.java.assembler;

import main.java.assembler.command.Command;

import java.util.HashMap;

class CommandParser {

    static CommandType getCommandType(String line) {
        System.out.println("first character: " + line.charAt(0));
        switch (line.charAt(0)) {
            case '@':
                return CommandType.ACOMMAND;
            case '(':
                return CommandType.LCOMMAND;
            default:
                return CommandType.CCOMMAND;
        }
    }

    static void parseLabel(String line, HashMap<String, Integer> symbols, int lineCount) {
        String label = CommandFactory.getCommand(line, CommandType.LCOMMAND, symbols).processAndGetValue(symbols);
        symbols.put(label, lineCount + 1);
    }

    static String parseCommand(String line, HashMap<String, Integer> symbols) {
        CommandType commandType = getCommandType(line);
        Command command = CommandFactory.getCommand(line, commandType, symbols);
        return command.processAndGetValue(symbols);
    }
}
