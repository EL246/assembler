package main.java.assembler;

import main.java.assembler.command.ACommand;
import main.java.assembler.command.CCommand;
import main.java.assembler.command.Command;
import main.java.assembler.command.LCommand;

import java.util.HashMap;

public enum CommandType {
    ACOMMAND {
        @Override
        Command getCommand(String line, HashMap<String, Integer> symbols){
            return new ACommand(line);
        }
    },
    CCOMMAND{
        @Override
        Command getCommand(String line, HashMap<String, Integer> symbols){
            return new CCommand(line);
        }
    },
    LCOMMAND {
        @Override
        Command getCommand(String line, HashMap<String, Integer> symbols){
            return new LCommand(line);
        }
    };

    abstract Command getCommand(String line, HashMap<String, Integer> symbols);
}
