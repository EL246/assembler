package main.java.assembler.command;

import java.util.HashMap;

public class LCommand implements Command {
    private String line;

    public LCommand(String line) {
        line = line.replace("(","");
        line = line.replace(")","");
        this.line = line;
    }

    @Override
    public String processAndGetValue(HashMap<String, Integer> symbols) {
        return line;
    }
}
