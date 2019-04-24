package main.java.assembler.command;

import main.java.assembler.file.SymbolTable;

public interface Command {

    String processAndGetValue(SymbolTable symbols);
}
