package main.java.assembler.command;

import java.util.HashMap;

public interface Command {

    String processAndGetValue(HashMap<String, Integer> symbols);
}
