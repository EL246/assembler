package main.java.assembler.command;

import main.java.assembler.file.SymbolTable;

public class ACommand implements Command {
    private static int newRegisterValue = 16;
    private static int registerBits = 16;
    
    private String line;

    public ACommand(String line) {
        this.line = line;
    }

    @Override
    public String processAndGetValue(SymbolTable symbols) {
        removeExtraCharacters();
        int value;
        try {
            value = Short.parseShort(line);
        } catch (NumberFormatException e) {
            value = checkOrUpdateSymbolTable(symbols);
        }
        return getBinaryValue(value);
    }

    private int checkOrUpdateSymbolTable(SymbolTable symbols) {
        int value;
        if (symbols.getSymbol(line) == null) {
            value = addToSymbolTable(symbols);
        } else {
            value = symbols.getSymbol(line);
        }
        return value;
    }

    private int addToSymbolTable(SymbolTable symbols) {
        int value;
        value = newRegisterValue;
        symbols.addSymbol(line, newRegisterValue);
        newRegisterValue++;
        return value;
    }

    private void removeExtraCharacters() {
        StringBuilder stringBuilder = new StringBuilder(line);
        line = stringBuilder.deleteCharAt(0).toString();
    }

    private String getBinaryValue(Integer value) {
        StringBuilder bin = new StringBuilder(Integer.toBinaryString(value));
        while (bin.length() < registerBits) {
            bin.insert(0, "0");
        }
        return bin.toString();
    }
}
