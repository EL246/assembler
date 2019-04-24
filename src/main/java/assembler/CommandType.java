package main.java.assembler;

import main.java.assembler.command.ACommand;
import main.java.assembler.command.CCommand;
import main.java.assembler.command.Command;
import main.java.assembler.command.LCommand;

public enum CommandType {
    A_COMMAND {
        @Override
        Command getCommand(String line){
            return new ACommand(line);
        }
    },
    C_COMMAND {
        @Override
        Command getCommand(String line){
            return new CCommand(line);
        }
    },
    L_COMMAND {
        @Override
        Command getCommand(String line){
            return new LCommand(line);
        }
    };

    abstract Command getCommand(String line);
}
