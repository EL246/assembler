package main.java.assembler.command;

import main.java.assembler.file.SymbolTable;

public class ACommand implements Command{
    private static int n = 16;
    private String line;

    public ACommand(String line) {
        this.line = line;
    }

    @Override
    public String processAndGetValue(SymbolTable symbols) {
        processLine();
        int value;
        try {
            value = Short.parseShort(line);
        } catch (NumberFormatException e){
            if(symbols.getSymbol(line)==null){
                value = n;
                symbols.addSymbol(line, n);
                n++;
            } else {
                value = symbols.getSymbol(line);
            }
        }
        return getValue(value);
    }

    private void processLine() {
        StringBuilder stringBuilder = new StringBuilder(line);
        line = stringBuilder.deleteCharAt(0).toString();
    }

    private String getValue(Integer value) {
        StringBuilder bin = new StringBuilder(Integer.toBinaryString(value));
        while (bin.length() < 16){
            bin.insert(0, "0");
        }
        return bin.toString();
    }
}
