package main.java.assembler;

import main.java.assembler.command.Command;

class CommandFactory {

    static Command getCommand(String line, CommandType commandType) {
        return commandType.getCommand(line);
    }
}
