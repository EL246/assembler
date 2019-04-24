package main.java.assembler;

import main.java.assembler.command.Command;

import java.util.HashMap;

class CommandFactory {

    static Command getCommand(String line, CommandType commandType, HashMap<String,Integer> symbols) {
        return commandType.getCommand(line, symbols);
    }
}
