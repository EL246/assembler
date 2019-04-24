package main.java.assembler.command;

import main.java.assembler.file.SymbolTable;

public class LCommand implements Command {
    private String line;

    public LCommand(String line) {
        line = line.replace("(","");
        line = line.replace(")","");
        this.line = line;
    }

    @Override
    public String processAndGetValue(SymbolTable symbols) {
        return line;
    }
}
