package main.java.assembler;

import main.java.assembler.command.Command;

class CommandFactory {

    static Command getCommand(String line) {
        return getCommandType(line).getCommand(line);
    }

    static CommandType getCommandType(String line) {
        switch (line.charAt(0)) {
            case '@':
                return CommandType.A_COMMAND;
            case '(':
                return CommandType.L_COMMAND;
            default:
                return CommandType.C_COMMAND;
        }
    }
}
